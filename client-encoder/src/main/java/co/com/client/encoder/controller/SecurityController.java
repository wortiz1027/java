package co.com.client.encoder.controller;

import co.com.client.encoder.dtos.Request;
import co.com.client.encoder.dtos.Response;
import co.com.client.encoder.service.ISecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security/api/v1")
@RequiredArgsConstructor
public class SecurityController {

    private final ISecurityService service;

    @PostMapping("/encrypt")
    public ResponseEntity<Response> all(@RequestBody Request request) {
        Response response = this.service.encrypt(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}