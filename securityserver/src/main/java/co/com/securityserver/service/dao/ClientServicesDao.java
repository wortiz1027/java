package co.com.securityserver.service.dao;

import co.com.securityserver.domain.OauthClientDetails;

public interface ClientServicesDao {

    void createClient(OauthClientDetails client);

    boolean isUserAvailable(String clientId);

    OauthClientDetails getClientById(String clientId);

    OauthClientDetails update(OauthClientDetails client);

    void delete(OauthClientDetails client);

}
