package co.com.alfaseguros.notificationsrecurring.domain.integration.files;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResponseFile implements Serializable{
		
	private static final long serialVersionUID = 1L;
	@JsonProperty("signedPolicy")
	private String signedPolicy;
	@JsonProperty("clauses")
	private String clauses;
	@JsonProperty("conditionedURL")
	private String conditionedURL;
	@JsonProperty("message")
	private String message;
}
