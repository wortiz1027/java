package co.edu.javeriana.configuracion.service;

import co.edu.javeriana.configuracion.extend.BaseToString;

public class ResponseService extends BaseToString{    
    public static final String SERVICIO_RESPUESTA_EXITO="OK";
    private Boolean exitoso;
    private ErrorResponse error;
    private Boolean isException;
    
    public ResponseService(){
        this.exitoso=Boolean.TRUE;
        this.isException=Boolean.FALSE;
        this.error= new ErrorResponse();
    }

    public ResponseService(Boolean exitoso, ErrorResponse error, Boolean isException) {
        this.exitoso = exitoso;
        this.error = error;
        this.isException = isException;
    }    
    
    public Boolean existenRegistros(){
        return this.error.getExistenRegistros();
    }
    public Boolean existenRegistrosInfo(){
        return this.error.getExistenRegistrosInfo();
    }
    public void setExitoso(final Boolean exitoso) {
        this.exitoso = exitoso;
    }

    public Boolean getExitoso() {
        return exitoso;
    }

    public void setError(final ErrorResponse error) {
        this.error = error;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setIsException(final Boolean isException) {
        this.isException = isException;
    }

    public Boolean getIsException() {
        return isException;
    }
}
