package co.com.alfaseguros.notificationsrecurring.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.web.client.RestTemplate;

import co.com.alfaseguros.notificationsrecurring.domain.Credential;
import co.com.alfaseguros.notificationsrecurring.domain.alfa.notifications.Request;
import co.com.alfaseguros.notificationsrecurring.domain.alfa.notifications.Response;
import co.com.alfaseguros.notificationsrecurring.domain.integration.files.RequestFile;
import co.com.alfaseguros.notificationsrecurring.domain.integration.files.ResponseFile;
import co.com.alfaseguros.notificationsrecurring.domain.integration.token.RequesToken;
import co.com.alfaseguros.notificationsrecurring.domain.integration.token.ResponseToken;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.common.ResponseSchedule;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.edit.RequestEdit;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.filter.RequestFilter;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.filter.ResponseFilter;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.getnotificationtype.RequestNotificationType;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.getnotificationtype.ResponseNotificationType;
import co.com.alfaseguros.notificationsrecurring.exceptions.ExcepcionAlfa;
import co.com.alfaseguros.notificationsrecurring.helper.KitControllerTestsHelper;
import co.com.alfaseguros.notificationsrecurring.repositories.AdlGetAttachmentsPostService;
import co.com.alfaseguros.notificationsrecurring.repositories.AdlGetTokenPostService;
import co.com.alfaseguros.notificationsrecurring.repositories.FindNotificationTypeById;
import co.com.alfaseguros.notificationsrecurring.repositories.NotificarionScheduleEdit;
import co.com.alfaseguros.notificationsrecurring.repositories.NotificarionScheduleGet;
import co.com.alfaseguros.notificationsrecurring.repositories.SendNotificationPostService;
import co.com.alfaseguros.notificationsrecurring.repositories.contracts.InfraServices;

@SpringBootTest
@ActiveProfiles("test")
class KitRepositoryTest {
	
	@Qualifier("findNotificationType")
	private InfraServices<RequestNotificationType, ResponseNotificationType> notificationType;
	
	@Qualifier("getToken")
	private InfraServices<RequesToken,ResponseToken> getToken;
	
	@Qualifier("attachments")
	private InfraServices<RequestFile,ResponseFile> getLinks;
	
	@Qualifier("editSchedule")
	private InfraServices<RequestEdit,ResponseSchedule> editNotification;
	
	@Qualifier("getSchedule")
	private InfraServices<RequestFilter,ResponseFilter> notificarionFilter;
	
	private co.com.alfaseguros.notificationsrecurring.repositories.contracts.Notification<co.com.alfaseguros.notificationsrecurring.domain.alfa.notifications.Request, Response> notifications;
	
	@Mock
	private RestTemplate template;
	
	@Mock
	private Credential credential;
	
	@Value("${adl.token.url}")
	private String urlToken;
	@Value("${adl.security.client.credentials}")
	private String clientCredentials;
	@Value("${adl.security.authorization}")
	private String authorization;
	@Value("${adl.security.grant.type}")
	private String grandtype;
	@Value("${adl.security.basic}")
	private String basic;	
	@Value("${adl.attachs.url}")
	private String urlAttachments;	
	@Value("${adl.attachs.parameters.policyId}")
	private String parameterPolicyId;
	@Value("${alfa.notifiactionschedule.url.editschedule}")
	private String editUrl;
	@Value("${alfa.notifiactionschedule.url.getschedule}")
	private String filteredtUrl;
	@Value("${alfa.notifiactionschedule.url.getnotificationtypeid}")
	private String urlNotificationType;
	@Value("${alfa.notifiactionschedule.parameters.notificationId}")
	private String notificationId;
	
	
	@Value("${alfa.notifications.url}")
    private String notificationUrl;
	
    @Value("${alfa.attachs.suffix}")
    private String suffix;
	
	
	private static final Logger log = LoggerFactory.getLogger(KitRepositoryTest.class);
	
	@BeforeEach
	public void setUp() {
			
		MockitoAnnotations.initMocks(this);		
		this.credential = KitControllerTestsHelper.buildCredential();
		
		this.getToken = new AdlGetTokenPostService(this.template, this.credential);
		this.getLinks = new AdlGetAttachmentsPostService(this.template);
		this.notifications = new SendNotificationPostService(this.template);		
		this.editNotification = new NotificarionScheduleEdit(this.template);
		this.notificarionFilter = new NotificarionScheduleGet(this.template);
		this.notificationType = new FindNotificationTypeById(this.template);
		
		org.springframework.test.util.ReflectionTestUtils.setField(this.getToken, "urlToken", this.urlToken);
		org.springframework.test.util.ReflectionTestUtils.setField(this.getToken, "clientCredentials", this.clientCredentials);	
		org.springframework.test.util.ReflectionTestUtils.setField(this.getToken, "authorization", this.authorization);	
		org.springframework.test.util.ReflectionTestUtils.setField(this.getToken, "grandtype", this.grandtype);	
		org.springframework.test.util.ReflectionTestUtils.setField(this.getToken, "basic", this.basic);				
		org.springframework.test.util.ReflectionTestUtils.setField(this.getLinks, "urlAttachments", this.urlAttachments);	
		org.springframework.test.util.ReflectionTestUtils.setField(this.getLinks, "authorization", this.authorization);	
		org.springframework.test.util.ReflectionTestUtils.setField(this.getLinks, "parameterPolicyId", this.parameterPolicyId);	
		
		org.springframework.test.util.ReflectionTestUtils.setField(this.notifications, "notificationUrl", this.notificationUrl);	
		org.springframework.test.util.ReflectionTestUtils.setField(this.notifications, "suffix", this.suffix);
		org.springframework.test.util.ReflectionTestUtils.setField(this.editNotification, "editUrl", this.editUrl);
		org.springframework.test.util.ReflectionTestUtils.setField(this.notificarionFilter, "filteredtUrl", this.filteredtUrl);
		
		org.springframework.test.util.ReflectionTestUtils.setField(this.notificationType, "urlNotificationType", this.urlNotificationType);
		org.springframework.test.util.ReflectionTestUtils.setField(this.notificationType, "notificationId", this.notificationId);
	}
	
	@Test
	void whenCallGetTokenOk() throws ExcepcionAlfa {	
		RequesToken request = new RequesToken();		
		Mockito.when(this.getToken.call(request)).thenReturn(KitControllerTestsHelper.buildRespToken());
		assertEquals(HttpStatus.OK,this.getToken.call(request).getStatusCode());
	}
	
	@Test
	void whenCallGetTokenInternalServerError() throws ExcepcionAlfa {	
		RequesToken request = new RequesToken();		
		Mockito.when(this.getToken.call(request)).thenReturn(KitControllerTestsHelper.buildRespTokenBad());
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,this.getToken.call(request).getStatusCode());
	}
	
	@Test
	void whenCallGetTokenThrowsException() throws ExcepcionAlfa {	
		RequesToken request = new RequesToken();
		Mockito.when(this.getToken.call(request)).thenThrow(NullPointerException.class);		
		assertThrows(ExcepcionAlfa.class, () -> this.getToken.call(request));		
	}
	
	@Test
	void whenCallAttachmentOk() throws ExcepcionAlfa {	
		RequestFile request = new RequestFile();		
		Mockito.when(this.getLinks.call(request)).thenReturn(KitControllerTestsHelper.buildRespAttchment());
		assertEquals(HttpStatus.OK,this.getLinks.call(request).getStatusCode());
	}
	
	@Test
	void whenCallAttachmentInternalServerError() throws ExcepcionAlfa {	
		RequestFile request = new RequestFile();		
		Mockito.when(this.getLinks.call(request)).thenReturn(KitControllerTestsHelper.buildRespBadAttchment());
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,this.getLinks.call(request).getStatusCode());
	}
	
	@Test
	void whenCallAttachmentThrowsException() throws ExcepcionAlfa {	
		RequestFile request = new RequestFile();
		Mockito.when(this.getLinks.call(request)).thenThrow(NullPointerException.class);		
		assertThrows(ExcepcionAlfa.class, () -> this.getLinks.call(request));		
	}
	
	@Test
	void whenCallSendNotificationOk() throws ExcepcionAlfa {	
		Request request = new Request();
		Map<String, byte[]> attachs = new HashMap<>();
		Mockito.when(this.notifications.call(request,attachs)).thenReturn(KitControllerTestsHelper.buildRespSendNotification());
		assertEquals(HttpStatus.OK,this.notifications.call(request,attachs).getStatusCode());
	}
	
	@Test
	void whenCallSendNotificationBadRequest() throws ExcepcionAlfa {	
		Request request = new Request();
		Map<String, byte[]> attachs = new HashMap<>();
		Mockito.when(this.notifications.call(request,attachs)).thenReturn(KitControllerTestsHelper.buildRespSendBadRespNotification());
		assertEquals(HttpStatus.BAD_REQUEST,this.notifications.call(request,attachs).getStatusCode());
	}
	
	@Test
	void whenCallCallSendNotificationThrowsException() throws ExcepcionAlfa {	
		Request request = new Request();
		Map<String, byte[]> attachs = new HashMap<>();
		Mockito.when(this.notifications.call(request,attachs)).thenThrow(NullPointerException.class);		
		assertThrows(ExcepcionAlfa.class, () -> this.notifications.call(request,attachs));		
	}
			
	@Test
	void whenCallRescurringEditOk() throws ExcepcionAlfa {	
		RequestEdit request = new RequestEdit();		
		Mockito.when(this.editNotification.call(request)).thenReturn(KitControllerTestsHelper.buildRespRecurringEdit());
		assertEquals(HttpStatus.OK,this.editNotification.call(request).getStatusCode());
	}	
	
	@Test
	void whenCallRescurringEditBadRequest() throws ExcepcionAlfa {	
		RequestEdit request = new RequestEdit();		
		Mockito.when(this.editNotification.call(request)).thenReturn(KitControllerTestsHelper.buildRespRecurringEditBad());
		assertEquals(HttpStatus.BAD_REQUEST,this.editNotification.call(request).getStatusCode());
	}
	
	@Test
	void whenCallRescurringEditThrowsException() throws ExcepcionAlfa{		
		RequestEdit request = new RequestEdit();
		Mockito.when(this.editNotification.call(request)).thenThrow(NullPointerException.class);		
		assertThrows(ExcepcionAlfa.class, () -> this.editNotification.call(request));		
	}
	
	@Test
	void whenCallRescurringGetOk() throws ExcepcionAlfa {	
		RequestFilter request = new RequestFilter();		
		Mockito.when(this.notificarionFilter.call(request)).thenReturn(KitControllerTestsHelper.buildRespRecurringFilter());
		assertEquals(HttpStatus.OK,this.notificarionFilter.call(request).getStatusCode());
	}
	
	@Test
	void whenCallRescurringGetBadRequest() throws ExcepcionAlfa {	
		RequestFilter request = new RequestFilter();		
		Mockito.when(this.notificarionFilter.call(request)).thenReturn(KitControllerTestsHelper.buildRespRecurringFilterBad());
		assertEquals(HttpStatus.BAD_REQUEST,this.notificarionFilter.call(request).getStatusCode());
	}
	
	@Test
	void whenCallRescurringGetThrowsException() throws ExcepcionAlfa{		
		RequestFilter request = new RequestFilter();
		Mockito.when(this.notificarionFilter.call(request)).thenThrow(NullPointerException.class);		
		assertThrows(ExcepcionAlfa.class, () -> this.notificarionFilter.call(request));		
	}
	
	@Test
	void whenCallNotificationTypeOk() throws ExcepcionAlfa {	
		RequestNotificationType request = new RequestNotificationType();	
		request.setNotificationTypeId("156156156151");
		Mockito.when(this.notificationType.call(request)).thenReturn(KitControllerTestsHelper.buildGetNotificationType());
		assertEquals(HttpStatus.OK,this.notificationType.call(request).getStatusCode());
	}
	
	@Test
	void whenCallNotificationTypeBadRequest() throws ExcepcionAlfa {	
		RequestNotificationType request = new RequestNotificationType();	
		request.setNotificationTypeId("156156156151");	
		Mockito.when(this.notificationType.call(request)).thenReturn(KitControllerTestsHelper.buildGetNotificationTypeBadResponse());
		assertEquals(HttpStatus.BAD_REQUEST,this.notificationType.call(request).getStatusCode());
	}
	
	@Test
	void whenCallNotificationTypeThrowsException() throws ExcepcionAlfa{		
		RequestNotificationType request = new RequestNotificationType();
		Mockito.when(this.notificationType.call(request)).thenThrow(NullPointerException.class);		
		assertThrows(ExcepcionAlfa.class, () -> this.notificationType.call(request));		
	}
}
