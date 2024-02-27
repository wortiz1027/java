package co.com.alfaseguros.notificationsrecurring.repositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import co.com.alfaseguros.notificationsrecurring.domain.alfa.notifications.Request;
import co.com.alfaseguros.notificationsrecurring.domain.alfa.notifications.Response;
import co.com.alfaseguros.notificationsrecurring.domain.enums.MessageResponseEnum;
import co.com.alfaseguros.notificationsrecurring.exceptions.ExcepcionAlfa;
import co.com.alfaseguros.notificationsrecurring.repositories.contracts.Notification;
import lombok.RequiredArgsConstructor;

@Component("notifications")
@RequiredArgsConstructor
public class SendNotificationPostService implements Notification<Request, Response>{
	
	private static final Logger LOG = LoggerFactory.getLogger(SendNotificationPostService.class);
	
	private final RestTemplate template;
	
    @Value("${alfa.notifications.url}")
    private String notificationUrl;
	
    @Value("${alfa.attachs.suffix}")
    private String suffix;
    
	@Override
	public ResponseEntity<Response> call(Request data, Map<String, byte[]> attachs) throws ExcepcionAlfa {		
		try {
			MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
			
			body.add("data", data);
			
			for (Map.Entry<String, byte[]> entry : attachs.entrySet()) 
				body.add("files", getUserFileResource(entry.getKey(), entry.getValue()));
			
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
	        
	        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);

	        return this.template.exchange(this.notificationUrl,
											HttpMethod.POST, 
											request, 
											Response.class);	        
		} catch (Exception e) {
			LOG.error("Error",e);	
			throw new ExcepcionAlfa(MessageResponseEnum.SERVICE_CALL_ERROR, " Notification ");			
		}		
	}
	
	private Resource getUserFileResource(final String filename, final byte[] attach) {
		try {
			Path tempFile = Files.createTempFile(filename, this.suffix);
			Files.write(tempFile, attach);
			return new FileSystemResource(tempFile.toFile());
		} catch (IOException e) {
			LOG.error("Error creating temp pdf user", e);
		}
		
		return null;		
	}
}