package co.com.service.dancarlton.services.infraestructure.repository;

import co.com.service.dancarlton.services.domain.dtos.ReservaDto;

import java.util.List;
import java.util.Optional;

public interface ReservasRepository {

    Optional<List<ReservaDto>> findAllBookings();
    Optional<ReservaDto> findBookinByCode(String code);

}
