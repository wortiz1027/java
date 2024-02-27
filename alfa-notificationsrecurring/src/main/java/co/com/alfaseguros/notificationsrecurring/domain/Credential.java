package co.com.alfaseguros.notificationsrecurring.domain;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Credential implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("adlClientId")
	private String adlClientId;
	
	@JsonProperty("adlSecretId")
	private String adlSecretId;
	
	@JsonProperty("accountId")
	private String accountId;
	
	@JsonProperty("apiKey")
	private String apiKey;
	
	@JsonProperty("apiLogin")
	private String apiLogin;
	
	@JsonProperty("merchantId")
	private String merchantId;
	
	@JsonProperty("urlPayment")
	private String urlPayment;
	
	@JsonProperty("urlQuery")
	private String urlQuery;

}
