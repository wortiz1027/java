package co.com.adf.modelo.exceptions;

import co.com.adf.modelo.enums.ErrorCodes;

public class CountryNotFoundException extends RuntimeException {
    @SuppressWarnings("compatibility:-5444906805967373820")
    private static final long serialVersionUID = 1L;

    private int errorCode;
   
    public CountryNotFoundException(String message) {
        super(message);
    }

    public CountryNotFoundException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode.getCode();
    }
    
    public CountryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CountryNotFoundException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode.getCode();
    }

    public int getErrorCode() {
        return errorCode;
    }
    
}