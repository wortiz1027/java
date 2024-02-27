package co.edu.javeriana.negocio;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

public class Reclutamiento implements Serializable {
    @SuppressWarnings("compatibility:-8074439440293736074")
    private static final long serialVersionUID = 1L;
    private List<Entrevista> entrevistas;
    
    public Reclutamiento() {
        super();
    }

    public List<Entrevista> getEntrevistas() {
        return this.entrevistas == null ? new ArrayList<Entrevista>(0) : this.entrevistas;
    }
    
    public void agregarEntrevista(final Entrevista entrevista) {
        getEntrevistas().add(entrevista);
    }
}
