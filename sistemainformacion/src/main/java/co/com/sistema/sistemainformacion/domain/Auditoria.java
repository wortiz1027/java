package co.com.sistema.sistemainformacion.domain;

import java.util.Date;

public class Auditoria {
    
    private int auditoriaKey;
    private Date fechaInicio;
    private Date fechaSalida;

    public Auditoria() {
    }

    public int getAuditoriaKey() {
        return auditoriaKey;
    }

    public void setAuditoriaKey(int auditoriaKey) {
        this.auditoriaKey = auditoriaKey;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    
    
}
