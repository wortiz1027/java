package co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.common;

import java.io.Serializable;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationPayload implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String email;
	private String notificationType;
	private List<ItemGenerico> attachmentsReferences;	
	private List<ItemGenerico> notificationParameters;

}
