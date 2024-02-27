package co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.getnotificationtype;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.com.alfaseguros.notificationsrecurring.domain.NotificationType;
import lombok.Data;

@Data
public class ResponseNotificationType implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("StatusCode")
	private String statusCode;
	
	@JsonProperty("StatusDesc")
    private String statusDesc;
	
	@JsonProperty("NotificationType")
    private NotificationType notificationType;

}
