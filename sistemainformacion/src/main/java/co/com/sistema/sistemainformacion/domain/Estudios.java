package co.com.sistema.sistemainformacion.domain;

import java.util.Date;

public class Estudios {
    
    private int estudiosId;
    private String lugar;
    private String titulo;
    private Date desde;
    private Date hasta;

    public Estudios() {
    }

    public int getEstudiosId() {
        return estudiosId;
    }

    public void setEstudiosId(int estudiosId) {
        this.estudiosId = estudiosId;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
    
    
    
}
