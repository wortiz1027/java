package co.edu.javeriana.configuracion.conf;

import co.edu.javeriana.configuracion.conf.bean.configuracion.BPMConf;
import co.edu.javeriana.configuracion.conf.bean.configuracion.OSBConf;
import co.edu.javeriana.configuracion.conf.bean.configuracion.WCCConf;

public class Configuracion {
    
    private OSBConf osb;
    private BPMConf bpm;
    private WCCConf wcc;
    private WCCConf visorWcc;
    private Boolean desarrollo;
    
    public Configuracion() {
        super();
        this.osb      = new OSBConf();
        this.bpm      = new BPMConf();
        this.wcc      = new WCCConf();
        this.visorWcc = new WCCConf();
    }
    
    public void setOsb(final OSBConf osb) {
        this.osb = osb;
    }

    public OSBConf getOsb() {
        return osb;
    }

    public void setBpm(final BPMConf bpm) {
        this.bpm = bpm;
    }

    public BPMConf getBpm() {
        return bpm;
    }

    public void setDesarrollo(final Boolean desarrollo) {
        this.desarrollo = desarrollo;
    }

    public Boolean getDesarrollo() {
        return desarrollo;
    }

    public void setWcc(WCCConf wcc) {
        this.wcc = wcc;
    }

    public WCCConf getWcc() {
        return wcc;
    }

    public void setVisorWcc(WCCConf visorWcc) {
        this.visorWcc = visorWcc;
    }

    public WCCConf getVisorWcc() {
        return visorWcc;
    }
}
