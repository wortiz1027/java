package co.edu.javeriana.external.services.avianca.application;

import co.edu.javeriana.external.services.avianca.dtos.Request;
import co.edu.javeriana.external.services.avianca.dtos.Response;

import java.util.concurrent.CompletableFuture;

public interface FlightsServices {

    Response getFlights(Request request);

}
