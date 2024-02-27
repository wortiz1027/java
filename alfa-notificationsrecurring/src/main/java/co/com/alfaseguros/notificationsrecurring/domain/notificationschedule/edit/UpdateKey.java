package co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.edit;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateKey implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	@JsonProperty("PolicyId")	
	private String policyId;
	
	@JsonProperty("NotificationType")
	private String notificationType;

}
