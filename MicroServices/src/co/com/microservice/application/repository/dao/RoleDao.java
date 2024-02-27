package co.com.microservice.application.repository.dao;

import java.util.List;

import co.com.microservice.application.model.Role;
import co.com.microservice.application.repository.generics.GenericDAO;


public interface RoleDao extends GenericDAO<Role, Long> {
	
	public List<Role> getRoleListNq();
	
}