package co.com.adf.modelo.exceptions;

import co.com.adf.modelo.enums.ErrorCodes;

public class CountryCodeNotFoundException extends RuntimeException {
    @SuppressWarnings("compatibility:851343879613915409")
    private static final long serialVersionUID = 1L;

    private int errorCode;
   
   public CountryCodeNotFoundException(String message) {
        super(message);
    }

    public CountryCodeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CountryCodeNotFoundException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode.getCode();
    }

    public int getErrorCode() {
        return errorCode;
    }
       
}