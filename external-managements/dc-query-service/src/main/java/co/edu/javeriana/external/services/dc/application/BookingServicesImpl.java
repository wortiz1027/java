package co.edu.javeriana.external.services.dc.application;

import co.edu.javeriana.external.services.dc.domain.Codes;
import co.edu.javeriana.external.services.dc.domain.Status;
import co.edu.javeriana.external.services.dc.domain.TipoHabitacion;
import co.edu.javeriana.external.services.dc.dtos.all.Request;
import co.edu.javeriana.external.services.dc.dtos.all.Response;
import co.edu.javeriana.external.services.dc.infraestructure.ws.client.DanCarltonWsClient;
import co.edu.javeriana.external.services.dc.infraestructure.ws.xsd.GetReservasByCodigoResponse;
import co.edu.javeriana.external.services.dc.infraestructure.ws.xsd.GetReservasResponse;
import co.edu.javeriana.external.services.dc.infraestructure.ws.xsd.Reserva;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class BookingServicesImpl implements BookingServices {

    private final DanCarltonWsClient client;

    @Override
    public CompletableFuture<Response> getAllBookings(Request request) {
        Response response = new Response();
        Status status = new Status();
        try {
            GetReservasResponse rs = this.client.getAllBookings(request);

            if (rs == null) {
                status.setCode(Codes.ERROR.name());
                status.setDescription("Error! there is an error getting bookings information");
                response.setStatus(status);
                return CompletableFuture.completedFuture(response);
            }

            if (rs.getHeader().getCode().equalsIgnoreCase(Codes.ERROR.name())) {
                status.setCode(rs.getHeader().getCode());
                status.setDescription(rs.getHeader().getDescription());
                response.setStatus(status);
                return CompletableFuture.completedFuture(response);
            }

            List<co.edu.javeriana.external.services.dc.domain.Reserva> reservas = new ArrayList<>();

            for (Reserva row : rs.getInformation().getReservas()) {
                co.edu.javeriana.external.services.dc.domain.Reserva item = new co.edu.javeriana.external.services.dc.domain.Reserva();

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

                reservas.add(item);
            }

            status.setCode(Codes.SUCCESS.name());
            status.setDescription("Bookings query has been success");
            response.setStatus(status);
            response.setReservas(reservas);

            return CompletableFuture.completedFuture(response);
        } catch(Exception e) {
            e.printStackTrace();
            status.setCode(Codes.ERROR.name());
            status.setDescription(String.format("There is an error getting bookings information : %s", e.getMessage()));
            response.setStatus(status);
            return CompletableFuture.completedFuture(response);
        }
    }

    @Override
    public CompletableFuture<co.edu.javeriana.external.services.dc.dtos.code.Response> getBookingsByCode(co.edu.javeriana.external.services.dc.dtos.code.Request request) {
        Status status = new Status();
        co.edu.javeriana.external.services.dc.domain.Reserva reserva = new co.edu.javeriana.external.services.dc.domain.Reserva();
        co.edu.javeriana.external.services.dc.dtos.code.Response response = new co.edu.javeriana.external.services.dc.dtos.code.Response();
        try {

            GetReservasByCodigoResponse rs = this.client.getBookingsByCode(request);

            if (rs == null) {
                status.setCode(Codes.ERROR.name());
                status.setDescription(String.format("Error! there is an error getting bookings information with code: %s", request.getCode()));
                response.setStatus(status);
                return CompletableFuture.completedFuture(response);
            }

            reserva.setIdReserva(rs.getDetail().getIdReserva());
            reserva.setCodigoReserva(rs.getDetail().getCodigoReserva());
            reserva.setFechaInicio(rs.getDetail().getFechaInicio());
            reserva.setFechaFin(rs.getDetail().getFechaFin());
            reserva.setNombreHuesped(rs.getDetail().getNombreHuesped());
            reserva.setTienePasaporte(rs.getDetail().getTienePasaporte());
            reserva.setNumeroPasaporte(rs.getDetail().getNumeroPasaporte());
            reserva.setNumeroDocumento(rs.getDetail().getNumeroDocumento());
            reserva.setObservaciones(rs.getDetail().getObservaciones());

            TipoHabitacion tipo = new TipoHabitacion();
            tipo.setIdTipo(rs.getDetail().getTipoHabitacion().getIdTipo());
            tipo.setDescripcion(rs.getDetail().getTipoHabitacion().getDescripcion());

            reserva.setTipoHabitacion(tipo);

            status.setCode(Codes.SUCCESS.name());
            status.setDescription("Bookings query has been success");
            response.setStatus(status);
            response.setReserva(reserva);

            return CompletableFuture.completedFuture(response);
        } catch(Exception e) {
            e.printStackTrace();
            status.setCode(Codes.ERROR.name());
            status.setDescription(String.format("There is an error getting bookings information with code %s : %s", request.getCode(), e.getMessage()));
            response.setStatus(status);
            return CompletableFuture.completedFuture(response);
        }
    }
}
