package co.com.adf.modelo.negocio;

public class ParNombreValor implements java.io.Serializable {
    @SuppressWarnings("compatibility:4204262760885569642")
    private static final long serialVersionUID = 1L;

    private String llave;
    private String valor;
    
    public ParNombreValor() {
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
