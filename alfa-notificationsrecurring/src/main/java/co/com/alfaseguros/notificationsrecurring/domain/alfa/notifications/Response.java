package co.com.alfaseguros.notificationsrecurring.domain.alfa.notifications;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Response implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("StatusCode")
	private String statusCode;
	
	@JsonProperty("StatusDesc")
    private String statusDesc;
	
}
