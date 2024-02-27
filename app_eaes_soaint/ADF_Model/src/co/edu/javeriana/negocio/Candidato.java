package co.edu.javeriana.negocio;

import java.math.BigDecimal;

import java.util.Date;

public class Candidato extends Persona {
    @SuppressWarnings("compatibility:3633362395647490550")
    private static final long serialVersionUID = 1L;
    
    private BigDecimal codigo;
    private String nombreCompleto;
    private Date fechaNacimiento;
    
    public Candidato() {
        super();
        this.fechaNacimiento = new Date();
    }
    
    public void generarNombreCompleto(){
        this.nombreCompleto = "";
        this.nombreCompleto = this.nombreCompleto + this.getPrimerNombre();
        this.nombreCompleto = this.nombreCompleto + (this.getSegundoNombre() != null ? " " + this.getSegundoNombre() : "");
        this.nombreCompleto = this.nombreCompleto + (this.getPrimeroApellido() != null ? " " + this.getPrimeroApellido() : "");
        this.nombreCompleto = this.nombreCompleto + (this.getSegundoApellido() != null ? " " + this.getSegundoApellido() : "");
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }
}
