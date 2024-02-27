package co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.filter;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusList implements Serializable{
		
	private static final long serialVersionUID = 1L;
	@JsonProperty("Status")
	private String status;
}
