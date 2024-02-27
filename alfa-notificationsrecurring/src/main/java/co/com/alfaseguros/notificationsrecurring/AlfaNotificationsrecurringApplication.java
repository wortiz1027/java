package co.com.alfaseguros.notificationsrecurring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AlfaNotificationsrecurringApplication {

	public static void main(String[] args) {		
		SpringApplication.run(AlfaNotificationsrecurringApplication.class, args);		
	}

}
