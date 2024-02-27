package co.com.securityserver.service.dao;

import co.com.securityserver.domain.TblSecRoles;

import java.util.List;

public interface RoleServicesDao {

    List<TblSecRoles> getAllRoles();

    TblSecRoles getInfoRole();

    void deleteRole();

    void updateRole();

}