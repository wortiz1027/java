package co.com.demo.clients.domain.events;

import co.com.demo.clients.domain.database.Client;
import lombok.Data;

import java.util.List;

@Data
public class Response implements java.io.Serializable {

    private List<Client> clients;

}
