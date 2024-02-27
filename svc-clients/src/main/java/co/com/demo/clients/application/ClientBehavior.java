package co.com.demo.clients.application;

import co.com.demo.clients.domain.database.Client;

import java.util.List;
import java.util.Optional;

public interface ClientBehavior {

    Optional<Client> getClientById(String dni);
    Optional<List<Client>> getAllClients();

}
