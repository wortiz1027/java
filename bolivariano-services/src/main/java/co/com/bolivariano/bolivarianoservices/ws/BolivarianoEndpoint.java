package co.com.bolivariano.bolivarianoservices.ws;

import co.com.bolivariano.bolivarianoservices.domain.xsd.GetJourneyRequest;
import co.com.bolivariano.bolivarianoservices.domain.xsd.GetJourneyResponse;
import co.com.bolivariano.bolivarianoservices.exceptions.FTPErrors;
import co.com.bolivariano.bolivarianoservices.services.BolivarianoServices;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.concurrent.ExecutionException;

@Endpoint
@RequiredArgsConstructor
public class BolivarianoEndpoint {

    private final BolivarianoServices service;

    @PayloadRoot(namespace = "http://co.bolivariano.com/journeys", localPart = "GetJourneyRequest")
    @ResponsePayload
    public GetJourneyResponse getJourneys(@RequestPayload GetJourneyRequest request) throws FTPErrors, ExecutionException, InterruptedException {
        return service.download().get();
    }

}
