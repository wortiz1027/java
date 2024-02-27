package co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification implements Serializable{
		
	private static final long serialVersionUID = 1L;
	private String policyId;		
	private String notificationType ;	
	private NotificationPayload notificationPayload ;
	private String notificationStatus;
	private String transactionTime;
	private String notificationTime;
	private Integer retries;
	private String retriesTime;			

	public String getPolicyId() {
		return policyId;
	}
	
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	
	public String getNotificationType() {
		return notificationType;
	}
	
	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}
	
	public NotificationPayload getNotificationPayload() {
		return notificationPayload;
	}	
	
	public void setNotificationPayload(NotificationPayload notificationPayload) {
		this.notificationPayload = notificationPayload;
	}	
	
	public String getNotificationStatus() {
		return notificationStatus;
	}
	
	public void setNotificationStatus(String notificationStatus) {
		this.notificationStatus = notificationStatus;
	}	
	
	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}
	
	public String getNotificationTime() {
		return notificationTime;
	}

	public void setNotificationTime(String notificationTime) {
		this.notificationTime = notificationTime;
	}
	
	public Integer getRetries() {
		return retries;
	}

	public void setRetries(Integer retries) {
		this.retries = retries;
	}
	
	public String getRetriesTime() {
		return retriesTime;
	}

	public void setRetriesTime(String retriesTime) {
		this.retriesTime = retriesTime;
	}	
}
