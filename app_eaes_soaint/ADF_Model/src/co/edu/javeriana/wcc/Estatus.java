package co.edu.javeriana.wcc;

import java.io.Serializable;

public class Estatus implements Serializable {
    @SuppressWarnings("compatibility:4273248371900997521")
    private static final long serialVersionUID = 1L;
    
    private Integer codigo;
    private String mensaje;
    
    public Estatus() {
        super();
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
