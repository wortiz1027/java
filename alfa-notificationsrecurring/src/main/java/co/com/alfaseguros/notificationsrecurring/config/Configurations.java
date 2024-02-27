package co.com.alfaseguros.notificationsrecurring.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration
@ComponentScan("co.com.alfaseguros.notificationsrecurring.config")
public class Configurations {
	
	@Bean
    public RestTemplate template() {		
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new LoggingInterceptor());
		
		RestTemplate template = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
		template.setInterceptors(interceptors);
		
        return template;
    }
	
}
