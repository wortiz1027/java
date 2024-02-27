package co.edu.javeriana.wcc;

import java.io.Serializable;

public class GetFileResult implements Serializable {
    @SuppressWarnings("compatibility:4697282658553718532")
    private static final long serialVersionUID = 1L;
    
    private Documento informacionArhivo;
    private ArchivoPrimario archivoDescargado;
    private Estatus status;
    
    public GetFileResult() {
        super();
        this.informacionArhivo = new Documento();
        this.archivoDescargado = new ArchivoPrimario();
        this.status = new Estatus();
    }

    public void setInformacionArhivo(Documento informacionArhivo) {
        this.informacionArhivo = informacionArhivo;
    }

    public Documento getInformacionArhivo() {
        return informacionArhivo;
    }

    public void setArchivoDescargado(ArchivoPrimario archivoDescargado) {
        this.archivoDescargado = archivoDescargado;
    }

    public ArchivoPrimario getArchivoDescargado() {
        return archivoDescargado;
    }

    public void setStatus(Estatus status) {
        this.status = status;
    }

    public Estatus getStatus() {
        return status;
    }
}
