package co.edu.javeriana.configuracion.error;

import java.io.Serializable;

public class MensajeTipificado implements Serializable{
    @SuppressWarnings("compatibility:-8410972618944434580")
    private static final long serialVersionUID = 1L;
    private String msj;
    private Integer tipo;
    public MensajeTipificado() {
        super();
    }
    public MensajeTipificado(Integer tipo,String msj) {
        this.msj = msj;
        this.tipo = tipo;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public String getMsj() {
        return msj;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }
}
