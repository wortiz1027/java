package co.com.alfaseguros.notificationsrecurring.repositories;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import co.com.alfaseguros.notificationsrecurring.domain.enums.MessageResponseEnum;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.getnotificationtype.RequestNotificationType;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.getnotificationtype.ResponseNotificationType;
import co.com.alfaseguros.notificationsrecurring.exceptions.ExcepcionAlfa;
import co.com.alfaseguros.notificationsrecurring.repositories.contracts.InfraServices;
import lombok.RequiredArgsConstructor;

@Component("findNotificationType")
@RequiredArgsConstructor
public class FindNotificationTypeById implements InfraServices<RequestNotificationType, ResponseNotificationType>{
	
	private static final Logger LOG = LoggerFactory.getLogger(FindNotificationTypeById.class);
	
	private final RestTemplate template;
	
	@Value("${alfa.notifiactionschedule.url.getnotificationtypeid}")
	private String urlNotificationType;
	@Value("${alfa.notifiactionschedule.parameters.notificationId}")
	private String notificationId;

	@Override
	public ResponseEntity<ResponseNotificationType> call(RequestNotificationType data) throws ExcepcionAlfa {
		try{
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    
		    Map<String, String> urlParams = new HashMap<>();
		    urlParams.put(this.notificationId, data.getNotificationTypeId());
		    
		    UriComponents  builderUrl = UriComponentsBuilder.fromHttpUrl(this.urlNotificationType)
					  .queryParam(this.notificationId, data.getNotificationTypeId())
					  .build();	
					    
			HttpEntity<?> entity = new HttpEntity<>(headers);
		    
		    return this.template.exchange(
		    								builderUrl.toString(),
								            HttpMethod.GET,
								            entity,
								            ResponseNotificationType.class,
								            data.getNotificationTypeId()
										    );
			
			
		} catch (Exception e) {	
			LOG.error("Error",e);			
			throw new ExcepcionAlfa(MessageResponseEnum.SERVICE_CALL_ERROR, " findNotificationType ");			
		}
	}
}
