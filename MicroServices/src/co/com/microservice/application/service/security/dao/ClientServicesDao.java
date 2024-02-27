package co.com.microservice.application.service.security.dao;

import co.com.microservice.application.model.OauthClientDetails;

public interface ClientServicesDao {
	
	public void createClient(OauthClientDetails client);
	
	public boolean isUserAvailable(String clientId);
	
	public OauthClientDetails getClientById(String clientId);
	
	public OauthClientDetails actualizar(OauthClientDetails client);
	
	public void eliminar(OauthClientDetails client);
	
}
