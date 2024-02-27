package co.edu.javeriana.external.services.cc.application;

import co.edu.javeriana.external.services.cc.dtos.Request;
import co.edu.javeriana.external.services.cc.dtos.Response;

import java.util.concurrent.CompletableFuture;

public interface CreditCardServices {

    CompletableFuture<Response> getCreditCardValidation(Request request);
}
