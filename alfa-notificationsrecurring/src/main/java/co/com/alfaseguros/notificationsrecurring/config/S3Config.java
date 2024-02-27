package co.com.alfaseguros.notificationsrecurring.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3ClientBuilder;

@Configuration
public class S3Config {
	
private static final Logger LOG = LoggerFactory.getLogger(S3Config.class);
	
	private String endpoint;
	
	public S3Config(@Value("${aws.dev.endpoint:#{null}}") String endpoint) {
		super();
		this.endpoint = endpoint;
	}
	
    @Bean
    public S3Client s3Client() {    	
    	S3Client client = null;
    	try {
    		S3ClientBuilder builder = S3Client.builder();
    		
        	if (endpoint != null) builder.endpointOverride(new URI(endpoint));
        	
        	client = builder.build();
    	}catch(URISyntaxException error) {
    		LOG.error("Invalid url {}", endpoint, error);            
        }
    	
        return client;    
    }
    
}