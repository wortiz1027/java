package co.com.demo.products.exceptions;


import co.com.demo.products.domain.exception.ResponseException;
import co.com.demo.products.exceptions.bussines.ProductCodeEmptyOrNullExpection;
import co.com.demo.products.exceptions.bussines.ProductNotFoundException;
import co.com.demo.products.exceptions.validation.ServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ResponseException> clientError(ProductNotFoundException ex) {
        ResponseException response = new ResponseException();
        response.setCode("NOT_FOUND");
        response.setMessage(ex.getMessage());
        response.setTime(LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductCodeEmptyOrNullExpection.class)
    public ResponseEntity<ResponseException> dniError(ProductCodeEmptyOrNullExpection ex) {
        ResponseException response = new ResponseException();
        response.setCode("BAD_REQUEST");
        response.setMessage(ex.getMessage());
        response.setTime(LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<ResponseException> serverError(ServerException ex) {
        ResponseException response = new ResponseException();
        response.setCode("INTERNAL_SERVER_ERROR");
        response.setMessage(ex.getMessage());
        response.setTime(LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}