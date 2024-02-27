package co.com.microservice.application.service.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.microservice.application.anotaciones.InfoLogger;
import co.com.microservice.application.model.Role;
import co.com.microservice.application.repository.dao.UserDao;
import co.com.microservice.application.service.security.dao.UserServicesDao;
import co.com.microservice.application.utils.Constantes;

@Service("customUserDetailsService")
@Transactional
public class CustomUserDetailServices implements UserDetailsService, UserServicesDao {

	@Autowired
	private UserDao userDao;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	@InfoLogger(origen = "loadUserByUsername")
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		co.com.microservice.application.model.User user = userDao.loadUserByUsername(username);
		
	   if (user == null)
		   throw new UsernameNotFoundException(String.format(Constantes.MSG_ERROR_USUARIO_NO_REGISTRADO, username));

		return new User(user.getLogin(), 
				        user.getPassword(),
						Boolean.valueOf(user.getEnable()), 
						Boolean.valueOf(user.getAccountNonExpired()), 
						Boolean.valueOf(user.getCredentialNonExpired()), 
						Boolean.valueOf(user.getAccountNonLocked()),
						getAuthorities(user.getRoleList())
					   );
	}

	public Collection<? extends GrantedAuthority> getAuthorities(List<Role> role) {
		List<GrantedAuthority> authoritiesList = new ArrayList<GrantedAuthority>(2);

		Iterator<Role> iterRole = role.iterator();

		while (iterRole.hasNext()) {
			Role rol = iterRole.next();
			authoritiesList.add(new SimpleGrantedAuthority(rol.getRole()));
			System.out.println("ROLES --> " + rol.getRole());
		}

		return authoritiesList;
	}
	
	@Override
	public boolean isUserAvailable(String username) {
		
		boolean available = userDao.isUserAvailable(username);

		return available;
	}

	@Override
	public co.com.microservice.application.model.User getUserByLogin(String login) {
		return userDao.loadUserByUsername(login);
	}

	@Override
	public co.com.microservice.application.model.User actualizar(co.com.microservice.application.model.User u) {
		userDao.update(u);	
		return u;
	}

	@Override
	public void eliminar(co.com.microservice.application.model.User u) {
		userDao.delete(u.getIdUser().longValue());
	}

	@Override
	public void createUser(co.com.microservice.application.model.User u, List<Role> role) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		u.setRoleList(role);
		userDao.save(u);
	}

}