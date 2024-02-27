package co.com.alfaseguros.notificationsrecurring.scheduler;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import co.com.alfaseguros.notificationsrecurring.service.Operation;
import lombok.RequiredArgsConstructor;

@Component("quartz")
@RequiredArgsConstructor
public class NotificationScheduler {
	
	@Qualifier("notificationRecurring")
	private final Operation notificarionRecurring;
	
	private static Logger log = LoggerFactory.getLogger(NotificationScheduler.class);
		
	@Scheduled(cron = "${alfa.recurring.notificationrecurring.cron.expression}")
	public void schedulesRecurring() {
		log.info(" INICIO >>> {}", LocalDateTime.now());			
		this.notificarionRecurring.init();
	}
}
