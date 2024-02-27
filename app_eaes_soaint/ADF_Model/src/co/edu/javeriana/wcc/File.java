package co.edu.javeriana.wcc;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

public class File implements Serializable{
    @SuppressWarnings("compatibility:5917419994899858731")
    private static final long serialVersionUID = 1L;
    
    private Integer dID;
    private String tipoArchivo;
    private List<NameValue> extraProperty;
    
    public File() {
        super();
    }

    public void setDID(Integer dID) {
        this.dID = dID;
    }

    public Integer getDID() {
        return dID;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public List<NameValue> getExtraProperty() {
        return this.extraProperty == null ? new ArrayList<NameValue>(0) : this.extraProperty;
    }
}
