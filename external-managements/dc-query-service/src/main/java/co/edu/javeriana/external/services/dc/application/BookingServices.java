package co.edu.javeriana.external.services.dc.application;

import co.edu.javeriana.external.services.dc.dtos.all.Request;
import co.edu.javeriana.external.services.dc.dtos.all.Response;

import java.util.concurrent.CompletableFuture;

public interface BookingServices {

    CompletableFuture<Response> getAllBookings(Request request);
    CompletableFuture<co.edu.javeriana.external.services.dc.dtos.code.Response> getBookingsByCode(co.edu.javeriana.external.services.dc.dtos.code.Request request);

}
