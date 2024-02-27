package co.com.microservice.application.repository.dao;

import co.com.microservice.application.model.OauthClientDetails;
import co.com.microservice.application.repository.generics.GenericDAO;

public interface OAuthClientDAO  extends GenericDAO<OauthClientDetails, String>{
	
	public boolean isClientAvailable(String clientId);
	public OauthClientDetails loadClientById(String clientId);
	
}
