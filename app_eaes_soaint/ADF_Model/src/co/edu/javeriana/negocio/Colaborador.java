package co.edu.javeriana.negocio;

import co.edu.javeriana.comun.TipoComun;

public class Colaborador extends Persona {
    @SuppressWarnings("compatibility:5091127268150149933")
    private static final long serialVersionUID = 1L;
    private TipoComun rol;
    private boolean asignado;
    private String disponible;
    
    public Colaborador() {
        super();
        this.rol = new TipoComun();
    }

    public void setRol(TipoComun rol) {
        this.rol = rol;
    }

    public TipoComun getRol() {
        return rol;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    public boolean isAsignado() {
        return asignado;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public String getDisponible() {
        return disponible;
    }
}
