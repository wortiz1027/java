package co.edu.javeriana.external.services.bl.application;

import co.edu.javeriana.external.services.bl.dtos.Request;
import co.edu.javeriana.external.services.bl.dtos.Response;

import java.util.concurrent.CompletableFuture;

public interface JourneyServices {

    CompletableFuture<Response> getJourneys(Request request);

}
