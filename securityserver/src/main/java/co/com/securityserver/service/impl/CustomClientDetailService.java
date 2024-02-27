package co.com.securityserver.service.impl;

import co.com.securityserver.domain.OauthClientDetails;
import co.com.securityserver.repository.dao.OAuthClientDAO;
import co.com.securityserver.utils.annotations.InfoLogger;
import co.com.securityserver.utils.contants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;

import co.com.securityserver.service.dao.ClientServicesDao;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Transactional
@Service("customClientDetailService")
public class CustomClientDetailService implements ClientDetailsService, ClientServicesDao {

    @Autowired
    private OAuthClientDAO oAuthClientDAO;

    @Override
    public void createClient(OauthClientDetails client) {
        getoAuthClientDAO().save(client);
    }

    @Override
    public boolean isUserAvailable(String clientId) {

        if (clientId != null) {
            getoAuthClientDAO().getOne(new Integer(clientId));
            return true;
        }

        return false;
    }

    @Override
    public OauthClientDetails getClientById(String clientId) {
        OauthClientDetails oauthClientDetails = null;

        if (clientId != null    ){
            oauthClientDetails = getoAuthClientDAO().getOne(new Integer(clientId));
        }

        return oauthClientDetails;
    }

    @Override
    public OauthClientDetails update(OauthClientDetails client) {

        if (client != null){
            getoAuthClientDAO().saveAndFlush(client);
        }
        return client;
    }

    @Override
    public void delete(OauthClientDetails client) {
        if (client != null){
            getoAuthClientDAO().delete(new Integer(client.getClientId()));
        }
    }

    @Override
    @InfoLogger(origen = "loadClientByClientId")
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        if (getoAuthClientDAO().isClientAvailable(clientId) < 0) {
            throw new ClientRegistrationException(String.format(Constants.MSG_ERROR_CLIENTE_NO_REGISTRADO, clientId));
        }

        OauthClientDetails client = getoAuthClientDAO().loadClientById(clientId);

        BaseClientDetails clientDetails = new BaseClientDetails();

        List<String> authorities = Arrays.asList(client.getAuthorizedGrantTypes().split(","));

        List<GrantedAuthority> authoritiesList = new ArrayList<GrantedAuthority>();

        for (String s : authorities){
            authoritiesList.add(new SimpleGrantedAuthority(s));
        }

        Set<String> uris = new HashSet<String>(Arrays.asList(client.getWebServerRedirectUri().split(",")));

        clientDetails.setClientId(String.valueOf(client.getClientId()));
        clientDetails.setScope(Arrays.asList(client.getScope().split(",")));
        clientDetails.setAuthorizedGrantTypes(Arrays.asList(client.getAuthorizedGrantTypes().split(",")));
        clientDetails.setAuthorities(authoritiesList);
        clientDetails.setAccessTokenValiditySeconds(client.getAccessTokenValidity().intValue());
        clientDetails.setClientSecret(client.getClientSecret());
        clientDetails.setRegisteredRedirectUri(uris);
        clientDetails.setResourceIds(Arrays.asList(client.getResourceId().split(",")));

        String approve = client.getAutoapprove() == null ? "false" : "true";

        if(approve.equalsIgnoreCase("true"))
            clientDetails.setAutoApproveScopes(StringUtils.commaDelimitedListToSet(client.getAutoapprove()));
        else
            clientDetails.setAutoApproveScopes(new HashSet<String>());

        return clientDetails;
    }

    public OAuthClientDAO getoAuthClientDAO() {
        return oAuthClientDAO;
    }

    public void setoAuthClientDAO(OAuthClientDAO oAuthClientDAO) {
        this.oAuthClientDAO = oAuthClientDAO;
    }
}