package co.edu.javeriana.wcc;

import java.io.Serializable;

public class CheckinResult implements Serializable{
    @SuppressWarnings("compatibility:-8629830662999054154")
    private static final long serialVersionUID = 1L;
    
    private int dID;
    private int revision;
    private int idRevision;
    private String labelrevision;
    private Estatus status;
    
    public CheckinResult() {
        super();
        this.status = new Estatus();
    }

    public void setDID(int dID) {
        this.dID = dID;
    }

    public int getDID() {
        return dID;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public int getRevision() {
        return revision;
    }

    public void setIdRevision(int idRevision) {
        this.idRevision = idRevision;
    }

    public int getIdRevision() {
        return idRevision;
    }

    public void setLabelrevision(String labelrevision) {
        this.labelrevision = labelrevision;
    }

    public String getLabelrevision() {
        return labelrevision;
    }

    public void setStatus(Estatus status) {
        this.status = status;
    }

    public Estatus getStatus() {
        return status;
    }
}
