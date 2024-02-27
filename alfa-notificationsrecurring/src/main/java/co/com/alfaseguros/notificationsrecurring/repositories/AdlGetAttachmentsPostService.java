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

import co.com.alfaseguros.notificationsrecurring.domain.enums.MessageResponseEnum;
import co.com.alfaseguros.notificationsrecurring.domain.integration.files.RequestFile;
import co.com.alfaseguros.notificationsrecurring.domain.integration.files.ResponseFile;
import co.com.alfaseguros.notificationsrecurring.exceptions.ExcepcionAlfa;
import co.com.alfaseguros.notificationsrecurring.repositories.contracts.InfraServices;
import lombok.RequiredArgsConstructor;

@Component("attachments")
@RequiredArgsConstructor
public class AdlGetAttachmentsPostService implements InfraServices<RequestFile, ResponseFile>{
	
	private static final Logger LOG = LoggerFactory.getLogger(AdlGetAttachmentsPostService.class);
	
	private final RestTemplate template;
	
	@Value("${adl.attachs.url}")
	private String urlAttachments;
	@Value("${adl.security.authorization}")
	private String authorization;
	@Value("${adl.attachs.parameters.policyId}")
	private String parameterPolicyId;

	@Override
	public ResponseEntity<ResponseFile> call(RequestFile data) throws ExcepcionAlfa {
		try{
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.ALL));
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    headers.add(this.authorization, data.getAccesToken());
		    		    
		    Map<String, String> urlParams = new HashMap<>();
		    urlParams.put(this.parameterPolicyId, data.getPolicyId());
					    
			HttpEntity<?> entity = new HttpEntity<>(headers);
		    
		    return this.template.exchange(
    										this.urlAttachments,
								            HttpMethod.GET,
								            entity,
								            ResponseFile.class,
								            data.getPolicyId()
										    );
			
			
		} catch (Exception e) {	
			LOG.error("Error",e);			
			throw new ExcepcionAlfa(MessageResponseEnum.SERVICE_CALL_ERROR, " attachs ");			
		}
	}
}
