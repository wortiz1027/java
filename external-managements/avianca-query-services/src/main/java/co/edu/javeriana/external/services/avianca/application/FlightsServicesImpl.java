package co.edu.javeriana.external.services.avianca.application;


import co.edu.javeriana.external.services.avianca.dtos.Request;
import co.edu.javeriana.external.services.avianca.dtos.Response;
import co.edu.javeriana.external.services.avianca.domain.AvalaibleFlight;
import co.edu.javeriana.external.services.avianca.domain.StatusEnum;
import co.edu.javeriana.external.services.avianca.dtos.Status;
import co.edu.javeriana.external.services.avianca.infraestructure.client.AviancaWsClient;
import co.edu.javeriana.external.services.avianca.infraestructure.wsdl.model.GetFlightsResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class FlightsServicesImpl implements FlightsServices {

    private final AviancaWsClient service;


    @Override
    @HystrixCommand(fallbackMethod = "exampleCircuitBreaker")
    //public CompletableFuture<Response> getFlights(Request request) {
    public Response getFlights(Request request) {
        Response response = new Response();
        Status status = new Status();
        try {
            GetFlightsResponse rs = this.service.getFlights(request);

            /*if(false){
                throw new Exception("Exception message");
            }*/

            if (rs == null) {
                status.setCode(StatusEnum.ERROR.name());
                status.setDescription("Error! there is an error getting flights informations");
                response.setStatus(status);
                // return CompletableFuture.completedFuture(response);
                return response;
            }

            List<AvalaibleFlight> returnFlights = new ArrayList<>();
            List<AvalaibleFlight> departureFlights = new ArrayList<>();

            rs.getGetFlightsResult().getValue().getDepartureFlights().getValue().getAvalaibleFlight().stream().forEach(avalaibleFlight -> {
                AvalaibleFlight flight = new AvalaibleFlight();
                flight.setAirLine(avalaibleFlight.getAirLine().getValue());
                flight.setAmount(avalaibleFlight.getAmount());
                flight.setCityFrom(avalaibleFlight.getCityFrom().getValue());
                flight.setCityTo(avalaibleFlight.getCityTo().getValue());
                flight.setDestinationAirportCode(avalaibleFlight.getDestinationAirportCode());
                flight.setDestinationAirportName(avalaibleFlight.getDestinationAirportName().getValue());
                flight.setDurationString(avalaibleFlight.getDurationString().getValue());
                flight.setFlightEnd(avalaibleFlight.getFlightEnd().toGregorianCalendar().getTime());
                flight.setFlightNumber(avalaibleFlight.getFlightNumber().getValue());
                flight.setFlightScale(avalaibleFlight.getFlightScale().getValue());
                flight.setFlightScaleNumber(avalaibleFlight.getFlightScaleNumber());
                flight.setFlightStart(avalaibleFlight.getFlightStart().toGregorianCalendar().getTime());
                flight.setId(avalaibleFlight.getId());
                flight.setOriginAirportCode(avalaibleFlight.getOriginAirportCode());
                flight.setOriginAirportName(avalaibleFlight.getOriginAirportName().getValue());
                flight.setPassengersNumber(avalaibleFlight.getPassengersNumber());
                flight.setTotalDurationInMinutes(avalaibleFlight.getTotalDurationInMinutes());

                departureFlights.add(flight);
            });

            rs.getGetFlightsResult().getValue().getReturnFlights().getValue().getAvalaibleFlight().stream().forEach(avalaibleFlight -> {
                AvalaibleFlight flight = new AvalaibleFlight();
                flight.setAirLine(avalaibleFlight.getAirLine().getValue());
                flight.setAmount(avalaibleFlight.getAmount());
                flight.setCityFrom(avalaibleFlight.getCityFrom().getValue());
                flight.setCityTo(avalaibleFlight.getCityTo().getValue());
                flight.setDestinationAirportCode(avalaibleFlight.getDestinationAirportCode());
                flight.setDestinationAirportName(avalaibleFlight.getDestinationAirportName().getValue());
                flight.setDurationString(avalaibleFlight.getDurationString().getValue());
                flight.setFlightEnd(avalaibleFlight.getFlightEnd().toGregorianCalendar().getTime());
                flight.setFlightNumber(avalaibleFlight.getFlightNumber().getValue());
                flight.setFlightScale(avalaibleFlight.getFlightScale().getValue());
                flight.setFlightScaleNumber(avalaibleFlight.getFlightScaleNumber());
                flight.setFlightStart(avalaibleFlight.getFlightStart().toGregorianCalendar().getTime());
                flight.setId(avalaibleFlight.getId());
                flight.setOriginAirportCode(avalaibleFlight.getOriginAirportCode());
                flight.setOriginAirportName(avalaibleFlight.getOriginAirportName().getValue());
                flight.setPassengersNumber(avalaibleFlight.getPassengersNumber());
                flight.setTotalDurationInMinutes(avalaibleFlight.getTotalDurationInMinutes());

                returnFlights.add(flight);
            });

            response.setDepartureFlights(departureFlights);
            response.setReturnFlights(returnFlights);
            status.setCode(StatusEnum.SUCCESS.name());
            status.setDescription("There are rows availables");
            response.setStatus(status);

            // return CompletableFuture.completedFuture(response);
            return response;
        } catch(Exception e) {
            e.printStackTrace();
            status.setCode(StatusEnum.ERROR.name());
            status.setDescription(String.format("There is an error getting flights : %s", e.getMessage()));
            response.setStatus(status);
            //return CompletableFuture.completedFuture(response);
            return response;
        }

    }

    public Response exampleCircuitBreaker(Request request) {
        Response response = new Response();
        Status status = new Status();
        List<AvalaibleFlight> returnFlights = new ArrayList<>();
        List<AvalaibleFlight> departureFlights = new ArrayList<>();
        status.setCode(StatusEnum.SUCCESS.name());
        status.setDescription("Test Circuit Breaker");
        response.setDepartureFlights(departureFlights);
        response.setReturnFlights(returnFlights);
        response.setStatus(status);
        return response;
    }
}
