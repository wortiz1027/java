package co.edu.javeriana.negocio;

import java.io.Serializable;

import java.math.BigDecimal;

public class Recomendacion implements Serializable {
    @SuppressWarnings("compatibility:2704083585509988310")
    private static final long serialVersionUID = 1L;
    private BigDecimal codigoPrototipo;
    private String observacion;
    private boolean seleccionado;
    
    public Recomendacion() {
        super();
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public boolean getSeleccionado() {
        return seleccionado;
    }

    public void setCodigoPrototipo(BigDecimal codigoPrototipo) {
        this.codigoPrototipo = codigoPrototipo;
    }

    public BigDecimal getCodigoPrototipo() {
        return codigoPrototipo;
    }
}
