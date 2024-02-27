package co.com.alfaseguros.notificationsrecurring.domain.integration.token;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResponseToken implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("StatusCode")
	private String statusCode;
	
	@JsonProperty("StatusDesc")
    private String statusDesc;
	
	@JsonProperty("access_token")
	private String accesToken;
	
	@JsonProperty("expires_in")
	private int expiresIn;
	
	@JsonProperty("token_type")
	private String tokenType;

}
