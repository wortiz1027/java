package co.com.alfaseguros.notificationsrecurring.domain.integration.files;

import java.io.Serializable;

import lombok.Data;

@Data
public class RequestFile implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String policyId;	
	private String accesToken;
	private int expiresIn;
	private String tokenType;

}
