package co.com.demo.clients.application;

import co.com.demo.clients.domain.database.Client;
import co.com.demo.clients.exceptions.bussines.ClientNotFoundException;
import co.com.demo.clients.infraestructure.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServices implements ClientBehavior {

    private final ClientRepository repository;

    @Override
    public Optional<Client> getClientById(String dni) {

        if (dni.isEmpty()) throw new ClientNotFoundException("Client dni can not be null");

        Optional<Client> client = this.repository.findClientById(dni);

        if (!client.isPresent()) throw new ClientNotFoundException(String.format("Client with dni: [%s] not found", dni));

        return client;
    }

    @Override
    public Optional<List<Client>> getAllClients() {
        Optional<List<Client>> clients = this.repository.findAllClients();

        if (clients.isEmpty()) throw new ClientNotFoundException("There is no client registers");

        return clients;
    }
}
