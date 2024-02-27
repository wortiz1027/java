package co.com.sistema.sistemainformacion.domain.views;

import co.com.sistema.sistemainformacion.domain.Permiso;
import co.com.sistema.sistemainformacion.domain.Rol;
import co.com.sistema.sistemainformacion.domain.Usuario;
import java.util.List;

public class SecurityView {
    
    private Usuario usuario;
    private List<Rol> roles;  
    private Permiso permisos;

    public SecurityView() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public Permiso getPermisos() {
        return permisos;
    }

    public void setPermisos(Permiso permisos) {
        this.permisos = permisos;
    }
    
}