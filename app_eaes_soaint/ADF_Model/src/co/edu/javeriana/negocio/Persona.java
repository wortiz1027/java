package co.edu.javeriana.negocio;

import java.io.Serializable;

public class Persona implements Serializable {
    @SuppressWarnings("compatibility:-3267192247630181467")
    private static final long serialVersionUID = 1L;
    private Identificacion identificacion;
    private String primerNombre;
    private String segundoNombre;
    private String primeroApellido;
    private String segundoApellido;
    private String email;
    private String telefono;
        
    public Persona() {
        super();
        this.identificacion = new Identificacion();
    }

    public void setIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setPrimeroApellido(String primeroApellido) {
        this.primeroApellido = primeroApellido;
    }

    public String getPrimeroApellido() {
        return primeroApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }
}
