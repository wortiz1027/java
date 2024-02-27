package co.com.sistema.sistemainformacion.service.impl;

import co.com.sistema.sistemainformacion.domain.views.SecurityView;
import co.com.sistema.sistemainformacion.repository.dao.SecurityDao;
import co.com.sistema.sistemainformacion.service.dao.SecurityServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("securityServiceDao")
public class SecurityServiceDaoImpl implements SecurityServiceDao {
    
    @Autowired
    private SecurityDao securityDao;
    
    @Override
    public SecurityView validateUser(String username, String password) {
        return securityDao.getUsuario(username, password);
    }
    
}