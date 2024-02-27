package co.edu.javeriana.external.services.aa.application;

import co.edu.javeriana.external.services.aa.dtos.all.Request;
import co.edu.javeriana.external.services.aa.dtos.all.Response;

import java.util.concurrent.CompletableFuture;

public interface FlightsServices {

    CompletableFuture<Response> getAllFlights(Request request);
    CompletableFuture<co.edu.javeriana.external.services.aa.dtos.flight.Response> getDetailFlight(co.edu.javeriana.external.services.aa.dtos.flight.Request data);

}
