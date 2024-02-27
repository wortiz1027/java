package co.com.alfaseguros.notificationsrecurring.domain.enums;

public enum NotificationStatusEnum {
	
	PENDING ("PENDING"), 
	NOTIFIED ("NOTIFIED"), 
	RETRIES ("RETRIES"),
	CANCELLED ("CANCELLED"); 
	
	private final String codigo; 
	
	NotificationStatusEnum(String codigo){
        this.codigo=codigo;
    }
    
    public String getCodigo() {
        return codigo;
    }

}
