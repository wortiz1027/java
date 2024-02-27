package co.com.alfaseguros.notificationsrecurring.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
	
	@GetMapping("/")
	public ResponseEntity<String> healthCheck() {
		String message = String.format("Service callback is up! %s", LocalDateTime.now());
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
