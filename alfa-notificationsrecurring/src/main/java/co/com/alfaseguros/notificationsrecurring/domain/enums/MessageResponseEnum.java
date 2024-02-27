package co.com.alfaseguros.notificationsrecurring.domain.enums;

public enum MessageResponseEnum {
	
	OK ("Transaccion exitosa", 200),
	SYSTEM_ERROR ("Error general del sistema", 500),   
    DB_ERROR ("Error con la base de datos", 500),
    SERVICE_CALL_ERROR ("Error llamando al serivicio", 501), 
    BUCKET_CALL_ERROR ("Error llamando al bucket", 502), 
    BUILD_NOTIFICATION_ERROR ("Error generando la notificacion", 503), 
    DATA_VALIDATION ("Validacion de datos", 400);  
    
        
    private final String mensaje; 
    private final int codigo; 
    
    MessageResponseEnum(String mensaje,int codigo){
        this.codigo=codigo;
        this.mensaje=mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

}
