package co.com.sistema.sistemainformacion.domain;

public class Referencias {
    
    private int referenciaId;
    private String nombres;
    private String ocupacion;
    private Integer celular;

    public Referencias() {
    }

    public int getReferenciaId() {
        return referenciaId;
    }

    public void setReferenciaId(int referenciaId) {
        this.referenciaId = referenciaId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }
    
    
    
}