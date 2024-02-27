package co.com.adf.modelo.exceptions;

import co.com.adf.modelo.enums.ErrorCodes;

public class CountryCodeNullOrEmtyException extends RuntimeException {
    @SuppressWarnings("compatibility:7648451908343325063")
    private static final long serialVersionUID = 1L;

    private int errorCode;
   
    public CountryCodeNullOrEmtyException(String message) {
        super(message);
    }

    public CountryCodeNullOrEmtyException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode.getCode();
    }
    
    public CountryCodeNullOrEmtyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CountryCodeNullOrEmtyException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode.getCode();
    }

    public int getErrorCode() {
        return errorCode;
    }
    
}