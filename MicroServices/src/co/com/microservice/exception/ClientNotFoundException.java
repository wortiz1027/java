package co.com.microservice.exception;

public class ClientNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ClientNotFoundException(String descException){
		super(descException);
	}
	
}