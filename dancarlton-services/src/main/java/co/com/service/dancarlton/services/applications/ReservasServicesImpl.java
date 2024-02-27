package co.com.service.dancarlton.services.applications;

import co.com.service.dancarlton.services.domain.Status;
import co.com.service.dancarlton.services.domain.dtos.ReservaDto;
import co.com.service.dancarlton.services.domain.xsd.*;
import co.com.service.dancarlton.services.infraestructure.repository.ReservasRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ReservasServicesImpl implements ReservasServices {

    private static final Logger LOG = LoggerFactory.getLogger(ReservasServicesImpl.class);
    private final ReservasRepository repository;

    @Override
    public CompletableFuture<GetReservasResponse> getReservas() {
        Header header = new Header();
        ReservasList reservas = new ReservasList();
        GetReservasResponse response = new GetReservasResponse();
        try {

            Optional<List<ReservaDto>> lista = repository.findAllBookings();

            if (lista.get().size() == 0) {
                header.setCode(Status.EMPTY.name());
                header.setDescription("No se encontro informacion de los reservas");

                response.setHeader(header);
                response.setInformation(reservas);

                return CompletableFuture.completedFuture(response);
            }

            for (ReservaDto row : lista.get()) {
                Reserva item = new Reserva();

                item.setIdReserva(row.getIdReserva());
                item.setCodigoReserva(row.getCodigoReserva());
                item.setFechaInicio(row.getFechaInicio());
                item.setFechaFin(row.getFechaFin());
                item.setNombreHuesped(row.getNombreHuesped());
                item.setTienePasaporte(row.getTienePasaporte());
                item.setNumeroPasaporte(row.getNumeroPasaporte());
                item.setNumeroDocumento(row.getNumeroDocumento());
                item.setObservaciones(row.getObservaciones());

                TipoHabitacion tipo = new TipoHabitacion();
                tipo.setIdTipo(row.getTipoHabitacion().getIdTipo());
                tipo.setDescripcion(row.getTipoHabitacion().getDescripcion());

                item.setTipoHabitacion(tipo);
                reservas.getReservas().add(item);
            }

            header.setCode(Status.SUCCESS.name());
            header.setDescription("Informacion de reservas consultada exitosamente");

            response.setHeader(header);
            response.setInformation(reservas);

            return CompletableFuture.completedFuture(response);
        } catch(Exception e) {
            e.printStackTrace();
            header.setCode(Status.ERROR.name());
            header.setDescription(String.format("There is an error gettting Dan Carlton Bookings information", e.getMessage()));

            response.setHeader(header);

            return CompletableFuture.completedFuture(response);
        }
    }

    @Override
    public CompletableFuture<GetReservasByCodigoResponse> getReservasByCodigo(String codigo) {
        Header header = new Header();
        Reserva reserva = new Reserva();
        GetReservasByCodigoResponse response = new GetReservasByCodigoResponse();
        try {

            Optional<ReservaDto> booking = this.repository.findBookinByCode(codigo);

            if (booking.isEmpty()) {
                header.setCode(Status.NO_EXIST.name());
                header.setDescription(String.format("No se encontro informacion de la reservas con codigo: %s", codigo));

                response.setHeader(header);
                response.setDetail(reserva);
                return CompletableFuture.completedFuture(response);
            }

            reserva.setIdReserva(booking.get().getIdReserva());
            reserva.setCodigoReserva(booking.get().getCodigoReserva());
            reserva.setFechaInicio(booking.get().getFechaInicio());
            reserva.setFechaFin(booking.get().getFechaFin());
            reserva.setNombreHuesped(booking.get().getNombreHuesped());
            reserva.setTienePasaporte(booking.get().getTienePasaporte());
            reserva.setNumeroPasaporte(booking.get().getNumeroPasaporte());
            reserva.setNumeroDocumento(booking.get().getNumeroDocumento());
            reserva.setObservaciones(booking.get().getObservaciones());

            TipoHabitacion tipo = new TipoHabitacion();
            tipo.setIdTipo(booking.get().getTipoHabitacion().getIdTipo());
            tipo.setDescripcion(booking.get().getTipoHabitacion().getDescripcion());

            reserva.setTipoHabitacion(tipo);

            header.setCode(Status.SUCCESS.name());
            header.setDescription(String.format("Informacion de reservas con codigo: %s consultada exitosamente", codigo));

            response.setHeader(header);
            response.setDetail(reserva);

            return CompletableFuture.completedFuture(response);
        } catch(Exception e) {
            e.printStackTrace();
            header.setCode(Status.ERROR.name());
            header.setDescription(String.format("There is an error getting Dan Carlton Bookings details: %s", e.getMessage()));
            response.setHeader(header);

            return CompletableFuture.completedFuture(response);
        }
    }
}
