package co.edu.javeriana.ordersservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1")
public class HealtController {

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        String message = String.format("Service orders is up! %s", LocalDateTime.now());
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

}
