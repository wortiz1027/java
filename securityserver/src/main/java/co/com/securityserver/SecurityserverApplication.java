package co.com.securityserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"co.com.securityserver"})
@EntityScan(basePackages = {"co.com.securityserver"})
@ComponentScan(basePackages = {"co.com.securityserver"})
public class SecurityserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityserverApplication.class, args);
	}

}