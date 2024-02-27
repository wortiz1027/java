package co.com.alfaseguros.notificationsrecurring.domain;

import lombok.Data;

@Data
public class NotificationType implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;	
	
    private String notificationId;
	private String from;
	private String subject;
	private String body;
	private String template;
	
}
