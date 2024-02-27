package co.com.service.dancarlton.services.applications;

import co.com.service.dancarlton.services.domain.xsd.GetReservasByCodigoResponse;
import co.com.service.dancarlton.services.domain.xsd.GetReservasResponse;

import java.util.concurrent.CompletableFuture;

public interface ReservasServices {

    CompletableFuture<GetReservasResponse> getReservas();
    CompletableFuture<GetReservasByCodigoResponse> getReservasByCodigo(String codigo);

}
