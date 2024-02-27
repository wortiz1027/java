package co.edu.javeriana.bpm.application;

import java.util.concurrent.CompletableFuture;

public interface BPMServices {

    CompletableFuture<co.edu.javeriana.bpm.dtos.Response> getInstanciaBPM(co.edu.javeriana.bpm.dtos.Request data);
    CompletableFuture<co.edu.javeriana.bpm.dtos.Response> getCancelarBPM(co.edu.javeriana.bpm.dtos.Request data);

}
