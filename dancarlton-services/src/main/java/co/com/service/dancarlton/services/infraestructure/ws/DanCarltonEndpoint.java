package co.com.service.dancarlton.services.infraestructure.ws;

import co.com.service.dancarlton.services.applications.ReservasServices;
import co.com.service.dancarlton.services.domain.xsd.GetReservasByCodigoRequest;
import co.com.service.dancarlton.services.domain.xsd.GetReservasByCodigoResponse;
import co.com.service.dancarlton.services.domain.xsd.GetReservasRequest;
import co.com.service.dancarlton.services.domain.xsd.GetReservasResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.concurrent.ExecutionException;

@Endpoint
@RequiredArgsConstructor
public class DanCarltonEndpoint {

    private final ReservasServices service;

    @PayloadRoot(namespace = "http://co.dancarlton.com/reservas", localPart = "GetReservasRequest")
    @ResponsePayload
    public GetReservasResponse getReservas(@RequestPayload GetReservasRequest request) throws ExecutionException, InterruptedException {
        return service.getReservas().get();
    }

    @PayloadRoot(namespace = "http://co.dancarlton.com/reservas", localPart = "GetReservasByCodigoRequest")
    @ResponsePayload
    public GetReservasByCodigoResponse getReservasByCodigo(@RequestPayload GetReservasByCodigoRequest request) throws ExecutionException, InterruptedException {
        return service.getReservasByCodigo(request.getKey()).get();
    }

}
