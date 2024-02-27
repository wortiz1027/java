package co.com.adf.modelo.enums;

public enum ErrorCodes {
    COUNTRY_CODE_NOT_FOUND(30001),
    COUNTRY_CODE_ERROR_LENGTH(30002),
    COUNTRY_CODE_ISO_ERROR(30003),
    COUNTRY_CODE_NULL_EMPTY_ERROR(30004),
    COUNTRY_NOT_FOUND_ERROR(30005);
    
    private int code;
    
    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
