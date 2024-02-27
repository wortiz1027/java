package co.edu.javeriana.negocio;

import java.io.Serializable;

public class Identificacion implements Serializable {
    @SuppressWarnings("compatibility:3946871363933427160")
    private static final long serialVersionUID = 1L;
    private String tipo;
    private String numero;
    
    public Identificacion() {
        super();
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
}
