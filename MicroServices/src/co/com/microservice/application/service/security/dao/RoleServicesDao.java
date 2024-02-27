package co.com.microservice.application.service.security.dao;

import java.util.List;

import co.com.microservice.application.model.Role;


public interface RoleServicesDao {
	
	public List<Role> getAllRoles();
	
	public Role getInfoRole();
	
	public void deleteRole();
	
	public void updateRole();
	
}