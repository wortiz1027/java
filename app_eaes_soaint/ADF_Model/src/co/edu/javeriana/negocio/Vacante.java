package co.edu.javeriana.negocio;

import java.io.Serializable;

import java.math.BigDecimal;

public class Vacante implements Serializable {
    @SuppressWarnings("compatibility:5366798286595312204")
    private static final long serialVersionUID = 1L;
    private BigDecimal codigo;
    private String nombre;
    private String descripcion;
    
    public Vacante() {
        super();
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
