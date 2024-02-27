package co.com.demo.products.exceptions.bussines;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProductCodeEmptyOrNullExpection extends RuntimeException {

    public ProductCodeEmptyOrNullExpection() {
        super();
    }

    public ProductCodeEmptyOrNullExpection(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductCodeEmptyOrNullExpection(String message) {
        super(message);
    }

    public ProductCodeEmptyOrNullExpection(Throwable cause) {
        super(cause);
    }
}