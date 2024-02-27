package co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.edit;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestEdit implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("UpdateKey")	
	private UpdateKey updateKey;
	@JsonProperty("NotificationStatus")
	private String notificationStatus;
	@JsonProperty("NotificationTime")
	private String notificationTime;
	@JsonProperty("Retries")
	private Integer retries;
	@JsonProperty("RetriesTime")
	private String retriesTime;

}
