package co.com.demo.clients.infraestructure.repository;

import co.com.demo.clients.domain.database.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Optional<Client> findClientById(String dni);
    Optional<List<Client>> findAllClients();

}
