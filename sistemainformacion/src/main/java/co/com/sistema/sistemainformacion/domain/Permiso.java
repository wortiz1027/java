package co.com.sistema.sistemainformacion.domain;

public class Permiso {
    
    private int permiso_menu;
    private int permiso_crear_usuarios;
    private int permiso_consultar_usuarios;
    private int permiso_actualizar_usuarios;
    private int permiso_eliminar_usuarios;

    public Permiso() {
    }

    public int getPermiso_menu() {
        return permiso_menu;
    }

    public void setPermiso_menu(int permiso_menu) {
        this.permiso_menu = permiso_menu;
    }

    public int getPermiso_crear_usuarios() {
        return permiso_crear_usuarios;
    }

    public void setPermiso_crear_usuarios(int permiso_crear_usuarios) {
        this.permiso_crear_usuarios = permiso_crear_usuarios;
    }

    public int getPermiso_consultar_usuarios() {
        return permiso_consultar_usuarios;
    }

    public void setPermiso_consultar_usuarios(int permiso_consultar_usuarios) {
        this.permiso_consultar_usuarios = permiso_consultar_usuarios;
    }

    public int getPermiso_actualizar_usuarios() {
        return permiso_actualizar_usuarios;
    }

    public void setPermiso_actualizar_usuarios(int permiso_actualizar_usuarios) {
        this.permiso_actualizar_usuarios = permiso_actualizar_usuarios;
    }

    public int getPermiso_eliminar_usuarios() {
        return permiso_eliminar_usuarios;
    }

    public void setPermiso_eliminar_usuarios(int permiso_eliminar_usuarios) {
        this.permiso_eliminar_usuarios = permiso_eliminar_usuarios;
    }
    
}
