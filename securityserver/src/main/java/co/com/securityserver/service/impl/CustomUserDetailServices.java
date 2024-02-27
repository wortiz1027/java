package co.com.securityserver.service.impl;

import co.com.securityserver.domain.TblSecRoles;
import co.com.securityserver.domain.TblSecUsers;
import co.com.securityserver.repository.dao.UserDao;
import co.com.securityserver.service.dao.UserServicesDao;
import co.com.securityserver.utils.annotations.InfoLogger;
import co.com.securityserver.utils.contants.Constants;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Service("customUserDetailsService")
@Transactional
public class CustomUserDetailServices implements UserDetailsService, UserServicesDao {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createUser(TblSecUsers u, List<TblSecRoles> role) {

    }

    @Override
    public boolean isUserAvailable(String username) {
        boolean available = userDao.isUserAvailable(username);

        return available;
    }

    @Override
    public TblSecUsers getUserByLogin(String login) {
        return userDao.loadUserByName(login);
    }

    @Override
    public TblSecUsers update(TblSecUsers u) {
        userDao.saveAndFlush(u);
        return u;
    }

    @Override
    public void delete(TblSecUsers u) {
        userDao.delete((Integer)u.getIdUser().intValue());
    }

    @Override
    @InfoLogger(origen = "loadUserByUsername")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TblSecUsers user = userDao.loadUserByName(username);

        if (user == null)
            throw new UsernameNotFoundException(String.format(Constants.MSG_ERROR_USUARIO_NO_REGISTRADO, username));

        return new User(user.getLogin(),
                        user.getPassword(),
                        Boolean.valueOf(user.getEnable()),
                        Boolean.valueOf(user.getAccountNonExpired()),
                        Boolean.valueOf(user.getCredentialNonExpired()),
                        Boolean.valueOf(user.getAccountNonLocket()),
                        getAuthorities(user.getRoleList())
        );
    }

    @InfoLogger(origen = "getAuthorities")
    public Collection<? extends GrantedAuthority> getAuthorities(List<TblSecRoles> role) {
        List<GrantedAuthority> authoritiesList = new ArrayList<GrantedAuthority>(2);

        Iterator<TblSecRoles> iterRole = role.iterator();

        while (iterRole.hasNext()) {
            TblSecRoles rol = iterRole.next();
            authoritiesList.add(new SimpleGrantedAuthority(rol.getRole()));
        }

        return authoritiesList;
    }
}