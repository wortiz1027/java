package co.com.alfaseguros.notificationsrecurring.exceptions;

import co.com.alfaseguros.notificationsrecurring.domain.enums.MessageResponseEnum;

public class ExcepcionAlfa extends Exception{
	
	private static final long serialVersionUID = 1L;

	private final int codError;

	public ExcepcionAlfa(Exception e) {
		super(e);
		this.codError = MessageResponseEnum.SYSTEM_ERROR.getCodigo();
	}
	
	public ExcepcionAlfa(MessageResponseEnum msg, String message) {
        super(msg.getMensaje() + ": " + message);
        this.codError = msg.getCodigo();
    }
    
    public ExcepcionAlfa(MessageResponseEnum msg) {
        super(msg.getMensaje());
        this.codError = msg.getCodigo();
    }    
   
    public ExcepcionAlfa(MessageResponseEnum msg, Throwable t) {
        super(msg.getMensaje(), t);
        this.codError = msg.getCodigo();
    }
    public ExcepcionAlfa(MessageResponseEnum msg,String message, Throwable t) {
        super(msg.getMensaje()+": "+message, t);
        this.codError = msg.getCodigo();
    }    
   
    public ExcepcionAlfa(int codError,String message) {
        super(message);
        this.codError=codError;
    }        
  
    public ExcepcionAlfa(String message, Throwable t) {
        super(message, t);
        this.codError = MessageResponseEnum.SYSTEM_ERROR.getCodigo();
    } 
   
    public ExcepcionAlfa(int codError, String message, Throwable t) {
        super(message, t);
        this.codError = codError;
    }    
   
    public ExcepcionAlfa(Throwable cause){
        super(cause);
        this.codError = MessageResponseEnum.SYSTEM_ERROR.getCodigo();
    }
    
    public int getCodError() {
        return codError;
    }
}
