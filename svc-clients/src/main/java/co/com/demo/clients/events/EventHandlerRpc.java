package co.com.demo.clients.events;

import co.com.demo.clients.application.ClientServices;
import co.com.demo.clients.domain.database.Client;
import co.com.demo.clients.domain.events.Request;
import co.com.demo.clients.domain.events.Response;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
public class EventHandlerRpc {

    private static final Logger LOG = LoggerFactory.getLogger(EventHandlerRpc.class);

    private final ClientServices service;

    @RabbitListener(queues = "${events.rpc.queue}", concurrency = "10")
    public Response receive(Request data) throws ExecutionException, InterruptedException {
        LOG.debug("RECEIVE: {}", data.getIds());

        Response response = new Response();
        List<String> ids = Arrays.asList(data.getIds().split(","));
        List<Client> clients = new ArrayList<>();

        for (String row : ids) {
            Client client = service.getClientById(row).get();
            clients.add(client);
        }

        response.setClients(clients);

        return response;
    }

}
