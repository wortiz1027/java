package co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.filter;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.common.Notification;
import lombok.Data;

@Data
public class ResponseFilter implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@JsonProperty("StatusCode")
	private String statusCode;
	
	@JsonProperty("StatusDesc")
    private String statusDesc;
	
	@JsonProperty("FilterNotificationSchedule")
	private transient List<Notification> listaNotification;	

}
