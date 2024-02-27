package co.edu.javeriana.wcc;

import java.io.Serializable;

public class ArchivoPrimario implements Serializable {
    @SuppressWarnings("compatibility:9110324937996925586")
    private static final long serialVersionUID = 1L;
    
    private String nombreArchivo;
    private byte[] contenidoArchivo;
    
    public ArchivoPrimario() {
        super();
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setContenidoArchivo(byte[] contenidoArchivo) {
        this.contenidoArchivo = contenidoArchivo;
    }

    public byte[] getContenidoArchivo() {
        return contenidoArchivo;
    }
}
