package co.com.sistema.sistemainformacion.service.dao;

import co.com.sistema.sistemainformacion.domain.views.SecurityView;

public interface SecurityServiceDao {
    
    public SecurityView validateUser(String username, String password);
    
}