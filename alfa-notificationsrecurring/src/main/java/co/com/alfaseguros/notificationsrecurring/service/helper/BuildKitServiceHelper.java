package co.com.alfaseguros.notificationsrecurring.service.helper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import co.com.alfaseguros.notificationsrecurring.domain.enums.MessageResponseEnum;
import co.com.alfaseguros.notificationsrecurring.domain.enums.NotificationStatusEnum;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.common.Notification;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.edit.RequestEdit;
import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.edit.UpdateKey;
import co.com.alfaseguros.notificationsrecurring.exceptions.ExcepcionAlfa;


public class BuildKitServiceHelper {
	
	private BuildKitServiceHelper() throws ExcepcionAlfa {
		throw new ExcepcionAlfa(MessageResponseEnum.SYSTEM_ERROR, "Error instanciando BuildKitServiceHelper" );
	}
		
	public static void buidNotificationRecurringEdit(final Notification notification, final RequestEdit requestEdit, final NotificationStatusEnum status, String zoneTime, int maxrecurring) {
		
		requestEdit.setUpdateKey(new UpdateKey(notification.getPolicyId(),notification.getNotificationType()));
		requestEdit.setNotificationStatus(status.getCodigo());
		LocalDateTime transactionDate = LocalDateTime.ofInstant(ZonedDateTime.now().toInstant(), ZoneId.of(zoneTime));
		
		if(status.getCodigo().equals(NotificationStatusEnum.NOTIFIED.getCodigo())) {
			requestEdit.setNotificationTime((DateTimeFormatter.ISO_DATE_TIME).format(transactionDate.withNano(0)));			
		}else {
			int countRecurring = notification.getRetries() +1;
			requestEdit.setRetries(countRecurring);
			requestEdit.setRetriesTime((DateTimeFormatter.ISO_DATE_TIME).format(transactionDate.withNano(0)));
			if(countRecurring == maxrecurring || countRecurring > maxrecurring) {
				requestEdit.setNotificationStatus(NotificationStatusEnum.CANCELLED.getCodigo());
			}
		}
	}	
}
