package co.com.sistema.sistemainformacion.repository.impl;

import co.com.sistema.sistemainformacion.domain.Permiso;
import co.com.sistema.sistemainformacion.domain.Rol;
import co.com.sistema.sistemainformacion.domain.Usuario;
import co.com.sistema.sistemainformacion.domain.views.SecurityView;
import co.com.sistema.sistemainformacion.repository.dao.SecurityDao;
import co.com.sistema.sistemainformacion.utils.InfoLogger;
import co.com.sistema.sistemainformacion.utils.Util;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("securityDao")
public class SecurityDaoImpl implements SecurityDao {
    
    @Autowired
    JdbcTemplate template;
    
    @Override
    @InfoLogger(origen = "getUsuario")
    public SecurityView getUsuario(String username, String password) {
        StringBuilder sbQuery = new StringBuilder();
        
        sbQuery.append("SELECT user.user_key, user.cedula, user.usuario, user.nombres, user.apellidos, user.direccion, user.fecha_nacimiento, user.celular, ");
        sbQuery.append("       roles.rol, ");
        sbQuery.append("       permision.permiso_menu, permision.permiso_consultar_usuarios, permision.permiso_crear_usuarios, permision.permiso_actualizar_usuarios, permision.permiso_eliminar_usuarios ");
        sbQuery.append("FROM politica.tbl_sec_user user INNER JOIN politica.tbls_sec_detail detail ON (user.user_key = detail.user_key) ");
        sbQuery.append("                                INNER JOIN politica.tbl_sec_roles roles ON (roles.rol_key = detail.rol_key)");
        sbQuery.append("                                INNER JOIN politica.tbl_sec_permissions permision ON (permision.permission_key = detail.permission_key) ");
        sbQuery.append("WHERE user.usuario  = ? ");
        sbQuery.append("AND   user.password = ? ");
        
        SecurityView security = null;
        
        try {
            
            security  = template.queryForObject(sbQuery.toString(), 
                                                new Object[]{username, password}, 
                                                (ResultSet resultSet, int rowNum) -> {
                                                           SecurityView securityView = new SecurityView();
                                                           Usuario usuario = new Usuario();
                                                           List<Rol> roles = new ArrayList<Rol>();
                                                           Permiso permiso = new Permiso();

                                                           if (!resultSet.wasNull()){
                                                               usuario.setCedula(Integer.parseInt(resultSet.getString("cedula")));
                                                               usuario.setUsuario(resultSet.getString("usuario"));
                                                               usuario.setNombres(resultSet.getString("nombres"));
                                                               usuario.setApellidos(resultSet.getString("apellidos"));
                                                               usuario.setDireccion(resultSet.getString("direccion"));
                                                               usuario.setFechaNacimiento(Util.formatDate(resultSet.getString("fecha_nacimiento")));
                                                               usuario.setCelular(new BigInteger(resultSet.getString("celular")));

                                                               roles.add(new Rol(resultSet.getString("fecha_nacimiento")));

                                                               permiso.setPermiso_menu(Integer.parseInt(resultSet.getString("permiso_menu")));
                                                               permiso.setPermiso_consultar_usuarios(Integer.parseInt(resultSet.getString("permiso_consultar_usuarios")));
                                                               permiso.setPermiso_crear_usuarios(Integer.parseInt(resultSet.getString("permiso_crear_usuarios")));
                                                               permiso.setPermiso_actualizar_usuarios(Integer.parseInt(resultSet.getString("permiso_actualizar_usuarios")));
                                                               permiso.setPermiso_eliminar_usuarios(Integer.parseInt(resultSet.getString("permiso_eliminar_usuarios")));                
                                                           }

                                                           securityView.setUsuario(usuario);
                                                           securityView.setRoles(roles);
                                                           securityView.setPermisos(permiso);

                                                           return securityView;
                                                       });
            
        } catch (EmptyResultDataAccessException ere) {
            return null;
        }
        
        return security;
    }
    
}