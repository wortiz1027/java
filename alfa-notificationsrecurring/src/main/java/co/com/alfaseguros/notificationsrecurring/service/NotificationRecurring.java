package co.com.alfaseguros.notificationsrecurring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.com.alfaseguros.notificationsrecurring.domain.NotificationType;
import co.com.alfaseguros.notificationsrecurring.domain.alfa.notifications.Request;
import co.com.alfaseguros.notificationsrecurring.domain.alfa.notifications.Response;
import co.com.alfaseguros.notificationsrecurring.domain.enums.MessageResponseEnum;
import co.com.alfaseguros.notificationsrecurring.domain.enums.NotificationStatusEnum;
import co.com.alfaseguros.notificationsrecurring.domain.integration.files.RequestFile;
import co.com.alfaseguros.notificationsrecurring.domain.integration.files.ResponseFile;
import co.com.alfaseguros.notificationsrecurring.domain.integration.token.RequesToken;
import co.com.alfaseguros.notificationsrecurring.domain.integration.token.ResponseToken;
import co.com.alfaseguros.notificationsrecurring.exceptions.ExcepcionAlfa;
import co.com.alfaseguros.notificationsrecurring.repositories.contracts.AttachmentsRepository;
import co.com.alfaseguros.notificationsrecurring.repositories.contracts.InfraServices;
import co.com.alfaseguros.notificationsrecurring.service.helper.BuildKitServiceHelper;
import co.com.alfaseguros.notificationsrecurring.utils.Utils;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.common.Notification;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.common.ResponseSchedule;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.edit.RequestEdit;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.filter.RequestFilter;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.filter.ResponseFilter;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.filter.StatusList;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.getnotificationtype.RequestNotificationType;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.getnotificationtype.ResponseNotificationType;
import lombok.RequiredArgsConstructor;

@Service("notificationRecurring")
@RequiredArgsConstructor
public class NotificationRecurring implements Operation {
	
	private static final Logger LOG = LoggerFactory.getLogger(NotificationRecurring.class);
	
	@Qualifier("findNotificationType")
	private final InfraServices<RequestNotificationType, ResponseNotificationType> notificationType;
	
	@Qualifier("getSchedule")
	private final InfraServices<RequestFilter,ResponseFilter> notificarionFilter;
	@Qualifier("editSchedule")
	private final InfraServices<RequestEdit,ResponseSchedule> editNotification;
	@Qualifier("attachments")
	private final InfraServices<RequestFile,ResponseFile> getLinks;
	@Qualifier("getToken")
	private final InfraServices<RequesToken,ResponseToken> getToken;
	
	
	private final co.com.alfaseguros.notificationsrecurring.repositories.contracts.Notification<co.com.alfaseguros.notificationsrecurring.domain.alfa.notifications.Request, Response> notifications;
		
	private final AttachmentsRepository attachments;
	
	@Value("${alfa.props.zone-time}")
	private String zoneTime;
	
	@Value("${adl.attachs.keyPoliza}")
    private String keyPolizaId;
	
	@Value("${alfa.recurring.notificationrecurring.max-recurring}")
	private int maxrecurring;
	
	@Value("${adl.attachs.files.clauses}")
    private String clauses;
	@Value("${adl.attachs.files.signedPolicy}")
    private String signedPolicy;
	
	@Override
	public void init() {
		try {
			final RequestFilter rqListNotification = new RequestFilter();
			buildGetFilteredNotification(rqListNotification);
			
			ResponseEntity<ResponseFilter> rsList = this.notificarionFilter.call(rqListNotification);
			LOG.info("ResponseGetTransaction ResponseGetTransaction, {} ", rsList.getStatusCode());
			if (rsList.getStatusCode().equals(HttpStatus.OK)) {
				ResponseFilter respNotifications = rsList.getBody();
				if(respNotifications != null && respNotifications.getListaNotification() != null && !respNotifications.getListaNotification().isEmpty()) {
					LOG.info("Cantidad de registros, {} ", respNotifications.getListaNotification().size());
					for(Notification notification : respNotifications.getListaNotification()) {
						createdNotification(notification);	
					}
				}else {
					 LOG.warn("There are no results!");
				}
				
			}else {
				 LOG.warn("There are not getRecurring to execute!");
			}
			
		} catch (Exception e) {
			LOG.error("Error on init NotificationRecurring", e);
		}
	}
	
	private void createdNotification(final Notification notification) {
		try {
			if(buildNotification(notification))
				generatedEditNotificaction(notification, NotificationStatusEnum.NOTIFIED);
			else
				generatedEditNotificaction(notification, NotificationStatusEnum.RETRIES);
		} catch (Exception e) {
			LOG.error("Error on init createdNotification", e);
			try {
				generatedEditNotificaction(notification, NotificationStatusEnum.RETRIES);
			}catch (ExcepcionAlfa exe) {
				LOG.error("Error generatedEditNotificaction en createdNotification ", e);
			}
		}
	}
	
	private boolean buildNotification(final Notification notification){
		try {
			RequestNotificationType noticationTypereq = new RequestNotificationType();
			generatedRequestTypeNotification(noticationTypereq,notification);
			
			ResponseEntity<ResponseNotificationType> notificationTypeRes = this.notificationType.call(noticationTypereq);
			
			if (notificationTypeRes == null || !notificationTypeRes.getStatusCode().is2xxSuccessful())
				throw new ExcepcionAlfa(MessageResponseEnum.SERVICE_CALL_ERROR, "findNotificationType ");
							
			ResponseNotificationType responseRotificationType = notificationTypeRes.getBody();
			if (responseRotificationType == null || responseRotificationType.getNotificationType() == null) 
				return Boolean.FALSE;
			
			final RequesToken tokenReq = new RequesToken();
			ResponseEntity<ResponseToken> tokenRes = this.getToken.call(tokenReq);
			
			LOG.info("Response: {} ", tokenRes.getStatusCode().is2xxSuccessful());			
			if (!tokenRes.getStatusCode().is2xxSuccessful() || tokenRes.getBody() == null) 
				return Boolean.FALSE;
			
			final RequestFile fileReq = new RequestFile();
			buildFileRequest(tokenRes.getBody(), notification, fileReq);
					
			ResponseEntity<ResponseFile> attachmentRes = this.getLinks.call(fileReq);
			LOG.info("Response: {} ", attachmentRes.getStatusCode());
			
			ResponseFile res = attachmentRes.getBody();
			if (!attachmentRes.getStatusCode().is2xxSuccessful() || res == null || res.getClauses() == null || res.getSignedPolicy() == null) {					
				if(res!= null && res.getMessage() != null) {
					LOG.error("Mensaje {} ",res.getMessage());
					throw new ExcepcionAlfa(MessageResponseEnum.SERVICE_CALL_ERROR, "attachs ");
				}else {						
					return Boolean.FALSE;
				}				
			}
			
			if(attachmentRes.getBody() == null)
				throw new ExcepcionAlfa(MessageResponseEnum.SERVICE_CALL_ERROR, " attachs ".concat("Body attachment invalid") );				
			else
				LOG.info("Response: Clauses: {} , SignedPolicy: {} ", res.getClauses(),res.getSignedPolicy());
						
			return buildNotification(attachmentRes, notification, responseRotificationType.getNotificationType());
		} catch (Exception e) {
			LOG.error("Error on init buildNotification", e);
			return Boolean.FALSE;
		}
	}
	
	private boolean buildNotification(final ResponseEntity<ResponseFile> attachmentRes, final Notification notification, final NotificationType notificationType) throws ExcepcionAlfa{
		try {
			Map<String, byte[]> attachs = new HashMap<>();
			Map<String, Object> params = new HashMap<>();
			Request mail = new Request();
			callPresignedUrl(attachmentRes.getBody(), attachs);
				
			notification.getNotificationPayload().getNotificationParameters().forEach(item -> params.put(item.getKey(), item.getValue()));		
			buidEmail(mail, notificationType, notification.getNotificationPayload().getEmail(), params);
			
			ResponseEntity<Response> notificatiotRes = this.notifications.call(mail, attachs);
			LOG.info("Response notification: {} ", notificatiotRes.getStatusCode());
			if(notificatiotRes.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
				Response resNot = notificatiotRes.getBody();
				if(resNot != null) 
					throw new ExcepcionAlfa(MessageResponseEnum.SERVICE_CALL_ERROR, "Error llamando a notificacion ".concat(resNot.getStatusDesc()) );									
				else
					throw new ExcepcionAlfa(MessageResponseEnum.SERVICE_CALL_ERROR, "Error llamando a notificacion ");					
			}
			if(!notificatiotRes.getStatusCode().equals(HttpStatus.OK) ) 				
				return Boolean.FALSE;			
			
			return Boolean.TRUE;
		}catch(Exception e) {
			throw Utils.evaluateException(e);
		}
	}
	
	public void buidEmail(final co.com.alfaseguros.notificationsrecurring.domain.alfa.notifications.Request mail, final NotificationType notification, String email, final Map<String, Object> params) {
		mail.setFrom(notification.getFrom());
		mail.setTo(email);
		mail.setSubject(notification.getSubject());
		mail.setTemplate(notification.getTemplate());
		mail.setBody(notification.getBody());
		mail.setParams(params);
	}
	
	private void generatedEditNotificaction(Notification notification, NotificationStatusEnum status) throws ExcepcionAlfa {
		try {
			final RequestEdit requestEdit = new RequestEdit();
			BuildKitServiceHelper.buidNotificationRecurringEdit(notification, requestEdit, status,this.zoneTime, this.maxrecurring);
			ResponseEntity<ResponseSchedule> editNotificationRes = this.editNotification.call(requestEdit);
			ResponseSchedule res = editNotificationRes.getBody(); 
			if(res == null || !editNotificationRes.getStatusCode().is2xxSuccessful() || !(String.valueOf(MessageResponseEnum.OK.getCodigo())).equals(res.getStatusCode()))
				LOG.error("Error editando la notificacion, PolicyId {} ",notification.getPolicyId());
		}catch(Exception e) {
			LOG.error("Error editando la notificacion, PolicyId {} ",notification.getPolicyId(),e);
		}
	}
	
	public void callPresignedUrl(final ResponseFile respFile, final Map<String, byte[]> attachs) throws ExcepcionAlfa {
		try {
			byte[] bytesUrl = this.attachments.getPresignedUrl(respFile.getClauses());		
			if(bytesUrl != null)
				attachs.put(this.clauses,bytesUrl);
			
			bytesUrl = this.attachments.getPresignedUrl(respFile.getSignedPolicy());		
			if(bytesUrl != null)
				attachs.put(this.signedPolicy,bytesUrl);
		} catch (Exception e) {        	
			throw Utils.evaluateException(e);
        }
	}
	
	private void buildGetFilteredNotification(RequestFilter rqListNotification) {
		final List<StatusList> statusList = new ArrayList<>(0);		
		statusList.add(new StatusList(NotificationStatusEnum.RETRIES.getCodigo()));
		rqListNotification.setStatusList(statusList);		
	}
	
	private void buildFileRequest(final ResponseToken respToken, final Notification notification, final RequestFile fileReq) throws ExcepcionAlfa {
		try {
			String policyHash = Utils.builtHash(notification.getPolicyId());
			fileReq.setPolicyId(policyHash);		
			fileReq.setAccesToken(respToken.getAccesToken());
		} catch (Exception e) {        	
			throw Utils.evaluateException(e);
        }
	}
	
	private void generatedRequestTypeNotification(RequestNotificationType noticationTypereq, final Notification notification) {
		noticationTypereq.setNotificationTypeId(notification.getNotificationType());
	}
}
