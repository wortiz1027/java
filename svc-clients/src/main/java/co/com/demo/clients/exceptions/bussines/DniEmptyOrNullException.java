package co.com.demo.clients.exceptions.bussines;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DniEmptyOrNullException extends RuntimeException {

    public DniEmptyOrNullException() {
        super();
    }

    public DniEmptyOrNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public DniEmptyOrNullException(String message) {
        super(message);
    }

    public DniEmptyOrNullException(Throwable cause) {
        super(cause);
    }
}