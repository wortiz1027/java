package co.com.adf.modelo.exceptions;

import co.com.adf.modelo.enums.ErrorCodes;

public class CountryCodeFormatException extends RuntimeException {
    @SuppressWarnings("compatibility:-5347122973390618192")
    private static final long serialVersionUID = 1L;

    private int errorCode;
   
    public CountryCodeFormatException(String message) {
        super(message);
    }

    public CountryCodeFormatException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode.getCode();
    }
    
    public CountryCodeFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public CountryCodeFormatException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode.getCode();
    }

    public int getErrorCode() {
        return errorCode;
    }
    
}