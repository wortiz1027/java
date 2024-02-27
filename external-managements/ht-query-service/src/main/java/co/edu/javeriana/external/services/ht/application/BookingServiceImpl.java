package co.edu.javeriana.external.services.ht.application;

import co.edu.javeriana.external.services.ht.dtos.Response;
import co.edu.javeriana.external.services.ht.domain.RestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final RestClient client;

    @Override
    public Response booking() {
        return client.getBooking();
    }
}
