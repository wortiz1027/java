package co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.save;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.common.NotificationPayload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestAdd implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("PolicyId")	
	private String policyId;
	
	@JsonProperty("NotificationType")
	private String notificationType ;
	
	@JsonProperty("NotificationPayload")
	private transient NotificationPayload notificationPayload;
	
	@JsonProperty("NotificationStatus")
	private String notificationStatus;
	
	@JsonProperty("TransactionTime")
	private String transactionTime;
	
	@JsonProperty("NotificationTime")
	private String notificationTime;
	
	@JsonProperty("Retries")
	private Integer retries;
	
	@JsonProperty("RetriesTime")
	private String retriesTime;
}
