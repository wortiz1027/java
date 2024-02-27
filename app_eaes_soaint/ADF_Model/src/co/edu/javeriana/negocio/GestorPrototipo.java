package co.edu.javeriana.negocio;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

public class GestorPrototipo implements Serializable {
    @SuppressWarnings("compatibility:6792497410643340515")
    private static final long serialVersionUID = 1L;
    private List<Colaborador> colaboradores;
    private Prototipo prototipo;
    
    public GestorPrototipo() {
        super();
        this.prototipo = new Prototipo();
    }

    public List<Colaborador> getColaboradores() {
        return this.colaboradores == null ? new ArrayList<Colaborador>(0) : this.colaboradores;
    }

    public void setPrototipo(Prototipo prototipo) {
        this.prototipo = prototipo;
    }

    public Prototipo getPrototipo() {
        return prototipo;
    }
}
