package co.edu.javeriana.external.services.aa.application;

import co.edu.javeriana.external.services.aa.dtos.Status;
import co.edu.javeriana.external.services.aa.dtos.all.Request;
import co.edu.javeriana.external.services.aa.dtos.all.Response;

import co.edu.javeriana.external.services.aa.infraestructure.client.AmericanAirlineWsClient;
import co.edu.javeriana.external.services.aa.infraestructure.wsdl.model.Flight;
import co.edu.javeriana.external.services.aa.infraestructure.wsdl.model.GetAllFlightsResponse;
import co.edu.javeriana.external.services.aa.infraestructure.wsdl.model.GetFlightsResponse;
import co.edu.javeriana.external.services.aa.infraestructure.wsdl.model.Seat;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class FlightsServicesImpl implements FlightsServices {

    private static Logger LOG = LoggerFactory.getLogger(FlightsServicesImpl.class);

    private final AmericanAirlineWsClient service;

    @Override
    public CompletableFuture<Response> getAllFlights(Request request) {
        Response response = new Response();
        Status status = new Status();
        try {
            GetAllFlightsResponse rs = this.service.getAllFlights(request);
            LOG.debug("RESPONSE-SOAP: {}", rs.getHeader().getCode());

            if (rs == null) {
                status.setCode(co.edu.javeriana.external.services.aa.domain.Status.ERROR.name());
                status.setDescription("Error! there is an error getting flights informations");
                response.setStatus(status);
                return CompletableFuture.completedFuture(response);
            }

            if (rs.getHeader().getCode().equalsIgnoreCase("101")) {
                status.setCode(co.edu.javeriana.external.services.aa.domain.Status.ERROR.name());
                status.setDescription(String.format("Error! [%s] request parameter is empty or null", rs.getHeader().getCode()));
                response.setStatus(status);
                return CompletableFuture.completedFuture(response);
            }

            if (rs.getHeader().getCode().equalsIgnoreCase("102")) {
                status.setCode(co.edu.javeriana.external.services.aa.domain.Status.ERROR.name());
                status.setDescription(String.format("Error! [%s] request parameter is empty or null", rs.getHeader().getCode()));
                response.setStatus(status);
                return CompletableFuture.completedFuture(response);
            }

            if (rs.getHeader().getCode().equalsIgnoreCase("103")) {
                status.setCode(co.edu.javeriana.external.services.aa.domain.Status.ERROR.name());
                status.setDescription(String.format("Error! [%s] Error perform flights query", rs.getHeader().getCode()));
                response.setStatus(status);
                return CompletableFuture.completedFuture(response);
            }

            List<co.edu.javeriana.external.services.aa.domain.Seat> seats = new ArrayList<>();
            List<co.edu.javeriana.external.services.aa.domain.Flight> fligths = new ArrayList<>();

            for (Flight row : rs.getInformation().getFlights().getFlight()) {
                co.edu.javeriana.external.services.aa.domain.Flight item = new co.edu.javeriana.external.services.aa.domain.Flight();
                item.setNumber(row.getNumber());
                item.setSource(row.getSource());
                item.setDestination(row.getDestination());
                item.setDate(row.getDate());

                for (Seat s : row.getSeats().getSeat()) {
                    co.edu.javeriana.external.services.aa.domain.Seat seat = new co.edu.javeriana.external.services.aa.domain.Seat();
                    seat.setNumber(s.getNumber());
                    seat.setAvailable(s.getAvailable());
                    seats.add(seat);
                }

                item.setSeats(seats);
                fligths.add(item);
            }

            status.setCode(co.edu.javeriana.external.services.aa.domain.Status.SUCCESS.name());
            status.setDescription("Flight query has been success");
            response.setStatus(status);
            response.setFlights(fligths);

            return CompletableFuture.completedFuture(response);
        } catch(Exception e) {
            e.printStackTrace();
            status.setCode(co.edu.javeriana.external.services.aa.domain.Status.ERROR.name());
            status.setDescription(String.format("There is an error getting flights : %s", e.getMessage()));
            response.setStatus(status);
            return CompletableFuture.completedFuture(response);
        }
    }

    @Override
    public CompletableFuture<co.edu.javeriana.external.services.aa.dtos.flight.Response> getDetailFlight(co.edu.javeriana.external.services.aa.dtos.flight.Request data) {
        co.edu.javeriana.external.services.aa.dtos.flight.Response response = new co.edu.javeriana.external.services.aa.dtos.flight.Response();
        Status status = new Status();
        try {
            GetFlightsResponse rs = this.service.getFlight(data);
            LOG.debug("RESPONSE-SOAP: {}", rs.getHeader().getCode());
            if (rs == null) {
                status.setCode(co.edu.javeriana.external.services.aa.domain.Status.ERROR.name());
                status.setDescription("Error! there is an error getting flights informations");
                response.setStatus(status);
                return CompletableFuture.completedFuture(response);
            }

            if (rs.getHeader().getCode().equalsIgnoreCase("101")) {
                status.setCode(co.edu.javeriana.external.services.aa.domain.Status.ERROR.name());
                status.setDescription(String.format("Error! [%s] request parameter is empty or null", rs.getHeader().getCode()));
                response.setStatus(status);
                return CompletableFuture.completedFuture(response);
            }

            if (rs.getHeader().getCode().equalsIgnoreCase("102")) {
                status.setCode(co.edu.javeriana.external.services.aa.domain.Status.ERROR.name());
                status.setDescription(String.format("Error! [%s] request parameter is empty or null", rs.getHeader().getCode()));
                response.setStatus(status);
                return CompletableFuture.completedFuture(response);
            }

            if (rs.getHeader().getCode().equalsIgnoreCase("103")) {
                status.setCode(co.edu.javeriana.external.services.aa.domain.Status.ERROR.name());
                status.setDescription(String.format("Error! [%s] Error perform flights query", rs.getHeader().getCode()));
                response.setStatus(status);
                return CompletableFuture.completedFuture(response);
            }

            Flight wsf = rs.getInformation().getFlight();
            List<co.edu.javeriana.external.services.aa.domain.Seat> seats = new ArrayList<>();
            co.edu.javeriana.external.services.aa.domain.Flight flight = new co.edu.javeriana.external.services.aa.domain.Flight();

            for (Seat s : wsf.getSeats().getSeat()) {
                co.edu.javeriana.external.services.aa.domain.Seat seat = new co.edu.javeriana.external.services.aa.domain.Seat();
                seat.setNumber(s.getNumber());
                seat.setAvailable(s.getAvailable());
                seats.add(seat);
            }

            flight.setNumber(wsf.getNumber());
            flight.setSource(wsf.getSource());
            flight.setDestination(wsf.getDestination());
            flight.setDate(wsf.getDate());
            flight.setSeats(seats);

            status.setCode(co.edu.javeriana.external.services.aa.domain.Status.SUCCESS.name());
            status.setDescription("Flight query has been success");
            response.setStatus(status);
            response.setFlight(flight);

            return CompletableFuture.completedFuture(response);
        } catch(Exception e) {
            e.printStackTrace();
            status.setCode(co.edu.javeriana.external.services.aa.domain.Status.ERROR.name());
            status.setDescription(String.format("There is an error getting flights : %s", e.getMessage()));
            response.setStatus(status);
            return CompletableFuture.completedFuture(response);
        }
    }
}
