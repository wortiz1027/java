package co.edu.javeriana.negocio;

import java.io.Serializable;

public class Documento implements Serializable {
    @SuppressWarnings("compatibility:6437698308472801597")
    private static final long serialVersionUID = 1L;

    private String idDoc;
    private String nombre;
    
    public Documento() {
        super();
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public String getIdDoc() {
        return idDoc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
