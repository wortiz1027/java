package co.edu.javeriana.configuracion.service;

import co.edu.javeriana.configuracion.extend.BaseToString;
import co.edu.javeriana.configuracion.utils.BooleanUtils;

public class ErrorResponse extends BaseToString{
    public static final String SERVICIO_CODIGO_NO_REGISTROS = "99";
    public static final String SERVICIO_CODIGO_NO_REGISTROS_INFO = "98";
    private String clase;
    private String metodo;
    private String codigo;
    private String tipo;
    private String descripcion;
    private Boolean existenRegistros;
    private Boolean existenRegistrosInfo;
    public ErrorResponse() {
        super();
        this.existenRegistros=Boolean.TRUE;
        this.existenRegistrosInfo=Boolean.FALSE;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
        if(BooleanUtils.existe(codigo) && codigo.equals(ErrorResponse.SERVICIO_CODIGO_NO_REGISTROS)){
            this.existenRegistros=Boolean.FALSE;
        }
        if(BooleanUtils.existe(codigo) && codigo.equals(ErrorResponse.SERVICIO_CODIGO_NO_REGISTROS_INFO)){
            this.existenRegistros=Boolean.FALSE;
            this.existenRegistrosInfo=Boolean.TRUE;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getClase() {
        return clase;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setExistenRegistros(Boolean existenRegistros) {
        this.existenRegistros = existenRegistros;
    }

    public Boolean getExistenRegistros() {
        return existenRegistros;
    }

    public void setExistenRegistrosInfo(Boolean existenRegistrosInfo) {
        this.existenRegistrosInfo = existenRegistrosInfo;
    }

    public Boolean getExistenRegistrosInfo() {
        return existenRegistrosInfo;
    }
}
