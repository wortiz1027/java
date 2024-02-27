package co.com.microservice.application.repository.dao;

import co.com.microservice.application.model.User;
import co.com.microservice.application.repository.generics.GenericDAO;

public interface UserDao extends GenericDAO<User, Long> {
	
	public boolean isUserAvailable(String login);
	
	public User loadUserByUsername(String username);
	
}