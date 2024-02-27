package co.com.sistema.sistemainformacion.repository.dao;

import co.com.sistema.sistemainformacion.domain.views.SecurityView;

public interface SecurityDao {
    
    public SecurityView getUsuario(String username, String password);
    
}