package co.com.securityserver.service.dao;

import co.com.securityserver.domain.TblSecRoles;
import co.com.securityserver.domain.TblSecUsers;

import java.util.List;

public interface UserServicesDao {

    void createUser(TblSecUsers u, List<TblSecRoles> role);

    boolean isUserAvailable(String username);

    TblSecUsers getUserByLogin(String login);

    TblSecUsers update(TblSecUsers u);

    void delete(TblSecUsers u);

}
