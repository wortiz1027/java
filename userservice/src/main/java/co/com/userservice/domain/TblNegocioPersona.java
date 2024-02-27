package co.com.userservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tbl_negocio_personas")
public class TblNegocioPersona implements java.io.Serializable {

    @Id
    @GeneratedValue
    private Long keyPersonas;

    private String nombrePersona;

    private String apellidoPersona;

    private Date fechaPersona;

    private BigDecimal cedulaPersona;

    public Long getKeyPersonas() {
        return keyPersonas;
    }

    public void setKeyPersonas(Long keyPersonas) {
        this.keyPersonas = keyPersonas;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public Date getFechaPersona() {
        return fechaPersona;
    }

    public void setFechaPersona(Date fechaPersona) {
        this.fechaPersona = fechaPersona;
    }

    public BigDecimal getCedulaPersona() {
        return cedulaPersona;
    }

    public void setCedulaPersona(BigDecimal cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }
}