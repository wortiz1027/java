package co.com.sistema.sistemainformacion.domain;

import java.util.Date;

public class Experiencia {
    
    private int experienciaId;
    private Date desde;
    private Date hasta;
    private String descripcion;

    public Experiencia() {
    }

    public int getExperienciaId() {
        return experienciaId;
    }

    public void setExperienciaId(int experienciaId) {
        this.experienciaId = experienciaId;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}