package co.com.alfaseguros.notificationsrecurring.domain.notificationschedule.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResponseSchedule implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("StatusCode")
	private String statusCode;
	
	@JsonProperty("StatusDesc")
    private String statusDesc;

}
