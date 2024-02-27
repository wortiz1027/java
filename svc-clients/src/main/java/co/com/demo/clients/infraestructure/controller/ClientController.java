package co.com.demo.clients.infraestructure.controller;

import co.com.demo.clients.application.ClientBehavior;
import co.com.demo.clients.domain.database.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ClientController {

    private final ClientBehavior services;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> clients() {
        return new ResponseEntity<>(services.getAllClients().get(), HttpStatus.OK);
    }

    @GetMapping("/clients/{dni}")
    public ResponseEntity<Client> bills(@PathVariable(required = true) String dni) {
        return new ResponseEntity<>(services.getClientById(dni).get(), HttpStatus.OK);
    }
}
