package co.com.microservice.application.service.security.dao;

import java.util.List;

import co.com.microservice.application.model.Role;
import co.com.microservice.application.model.User;

public interface UserServicesDao {
	
	public void createUser(User u, List<Role> role);
	
	public boolean isUserAvailable(String username);
	
	public User getUserByLogin(String login);
	
	public User actualizar(User u);
	
	public void eliminar(User u);
	
}