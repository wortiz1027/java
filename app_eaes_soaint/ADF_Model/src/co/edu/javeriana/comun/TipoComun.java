package co.edu.javeriana.comun;

import java.io.Serializable;

public class TipoComun implements Serializable {
    @SuppressWarnings("compatibility:-1164427726668043058")
    private static final long serialVersionUID = 1L;
    private String llave;
    private String valor;
    
    public TipoComun() {
        super();
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public String getLlave() {
        return llave;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
