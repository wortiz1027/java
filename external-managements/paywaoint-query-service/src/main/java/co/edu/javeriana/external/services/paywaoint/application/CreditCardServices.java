package co.edu.javeriana.external.services.paywaoint.application;

import co.edu.javeriana.external.services.paywaoint.dtos.Request;
import co.edu.javeriana.external.services.paywaoint.dtos.Response;

import java.util.concurrent.CompletableFuture;

public interface CreditCardServices {

    CompletableFuture<Response> getCreditCardValidation(Request request);
    CompletableFuture<Response> setChargeCreditCard(Request request);
}
