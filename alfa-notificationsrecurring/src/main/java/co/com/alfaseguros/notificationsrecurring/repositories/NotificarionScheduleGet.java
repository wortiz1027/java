package co.com.alfaseguros.notificationsrecurring.repositories;

import java.util.Arrays;

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

import co.com.alfaseguros.notificationsrecurring.domain.enums.MessageResponseEnum;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.filter.RequestFilter;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.filter.ResponseFilter;
import co.com.alfaseguros.notificationsrecurring.exceptions.ExcepcionAlfa;
import co.com.alfaseguros.notificationsrecurring.repositories.contracts.InfraServices;
import lombok.RequiredArgsConstructor;

@Component("getSchedule")
@RequiredArgsConstructor
public class NotificarionScheduleGet implements InfraServices<RequestFilter, ResponseFilter> {
	
private static final Logger LOG = LoggerFactory.getLogger(NotificarionScheduleGet.class);
	
	private final RestTemplate template;
	
	@Value("${alfa.notifiactionschedule.url.getschedule}")
	private String filteredtUrl;
	
	@Override
	public ResponseEntity<ResponseFilter> call(RequestFilter data) throws ExcepcionAlfa {
		try {
			HttpHeaders headers = new HttpHeaders();
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    headers.setContentType(MediaType.APPLICATION_JSON);
			
		    HttpEntity<RequestFilter> request = new HttpEntity<>(data, headers);
			
		    return template.exchange(this.filteredtUrl,
									  HttpMethod.POST, 
									  request, 
									  ResponseFilter.class);			
			
		} catch (Exception e) {			
			LOG.error("Error",e);	
			throw new ExcepcionAlfa(MessageResponseEnum.SERVICE_CALL_ERROR, "getFilterNotificationSchedule ");
		}
	}
}
