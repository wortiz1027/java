package co.com.alfaseguros.notificationsrecurring.repositories;

import java.util.Arrays;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import co.com.alfaseguros.notificationsrecurring.domain.Credential;
import co.com.alfaseguros.notificationsrecurring.domain.enums.MessageResponseEnum;
import co.com.alfaseguros.notificationsrecurring.domain.integration.token.RequesToken;
import co.com.alfaseguros.notificationsrecurring.domain.integration.token.ResponseToken;
import co.com.alfaseguros.notificationsrecurring.exceptions.ExcepcionAlfa;
import co.com.alfaseguros.notificationsrecurring.repositories.contracts.InfraServices;
import lombok.RequiredArgsConstructor;

@Component("token")
@RequiredArgsConstructor
public class AdlGetTokenPostService implements InfraServices<RequesToken, ResponseToken>{
	
	private static final Logger LOG = LoggerFactory.getLogger(AdlGetTokenPostService.class);
	
	
	private final RestTemplate template;
	private final Credential credential;
	
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
	
	@Override
	public ResponseEntity<ResponseToken> call(RequesToken data) throws ExcepcionAlfa {
		try{			
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.ALL));
		    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);	
		    headers.add(this.authorization, this.basic.concat(Base64.getEncoder().encodeToString((this.credential.getAdlClientId().concat(":").concat(this.credential.getAdlSecretId())).getBytes())));
		    MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
		    map.add(this.grandtype, this.clientCredentials);
		    
		    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
		    		    
		    return this.template.exchange(this.urlToken,
											   HttpMethod.POST, 
											   request, 
											   ResponseToken.class);			
		} catch (Exception e) {				
			LOG.error("Error",e);	
			throw new ExcepcionAlfa(MessageResponseEnum.SERVICE_CALL_ERROR, " Token ");
		}
	}
}

