package co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.getnotificationtype;

import java.io.Serializable;

import lombok.Data;

@Data
public class RequestNotificationType implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String notificationTypeId;

}
