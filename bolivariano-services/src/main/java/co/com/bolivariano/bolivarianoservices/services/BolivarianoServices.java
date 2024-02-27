package co.com.bolivariano.bolivarianoservices.services;

import co.com.bolivariano.bolivarianoservices.domain.xsd.GetJourneyResponse;
import co.com.bolivariano.bolivarianoservices.exceptions.FTPErrors;

import java.util.concurrent.CompletableFuture;

public interface BolivarianoServices {

    void connect() throws FTPErrors;
    CompletableFuture<GetJourneyResponse> download() throws FTPErrors;
    void disconnect() throws FTPErrors;

}
