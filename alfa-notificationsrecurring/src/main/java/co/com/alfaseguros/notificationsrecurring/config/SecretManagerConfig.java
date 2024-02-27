package co.com.alfaseguros.notificationsrecurring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.alfaseguros.notificationsrecurring.domain.Credential;
import co.com.alfaseguros.notificationsrecurring.exceptions.ExcepcionAlfa;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.DecryptionFailureException;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;


@Configuration
public class SecretManagerConfig {
	
	@Value("${alfa.security.secretName}")
	private String secretName;
	
	@Bean
	public Credential getSecret() throws ExcepcionAlfa {

        SecretsManagerClient client = SecretsManagerClient.builder().build();
        GetSecretValueResponse response = null;

        try {
            response = client.getSecretValue(GetSecretValueRequest.builder().secretId(this.secretName).build());
            return (new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)).readValue(response.secretString(), Credential.class);
        } catch (DecryptionFailureException e) {            
            throw e;
        } catch (Exception e) {
        	throw new ExcepcionAlfa(e);
        }	
     }
}
