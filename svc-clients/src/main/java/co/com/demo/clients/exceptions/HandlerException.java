package co.com.demo.clients.exceptions;

import co.com.demo.clients.domain.exception.ResponseException;
import co.com.demo.clients.exceptions.bussines.ClientNotFoundException;
import co.com.demo.clients.exceptions.bussines.DniEmptyOrNullException;
import co.com.demo.clients.exceptions.validation.ServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ResponseException> clientError(ClientNotFoundException ex) {
        ResponseException response = new ResponseException();
        response.setCode("NOT_FOUND");
        response.setMessage(ex.getMessage());
        response.setTime(LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DniEmptyOrNullException.class)
    public ResponseEntity<ResponseException> dniError(DniEmptyOrNullException ex) {
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