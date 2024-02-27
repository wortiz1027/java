package co.edu.javeriana.external.services.bl.application;

import co.edu.javeriana.external.services.bl.domain.Codes;
import co.edu.javeriana.external.services.bl.domain.Status;
import co.edu.javeriana.external.services.bl.dtos.Request;
import co.edu.javeriana.external.services.bl.dtos.Response;
import co.edu.javeriana.external.services.bl.infraestructure.client.BolivarianoWsClient;
import co.edu.javeriana.external.services.bl.infraestructure.wsdl.model.GetJourneyResponse;
import co.edu.javeriana.external.services.bl.infraestructure.wsdl.model.Passenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class JourneyServicesImpl implements JourneyServices {

    private final BolivarianoWsClient client;

    @Override
    public CompletableFuture<Response> getJourneys(Request request) {
        Response response = new Response();
        Status status = new Status();
        try {
            GetJourneyResponse rs = this.client.getAllJourneys(request);

            if (rs == null) {
                status.setCode(Codes.ERROR.name());
                status.setDescription("Error! there is an error getting passenger informations");
                response.setStatus(status);
                return CompletableFuture.completedFuture(response);
            }

            if (rs.getHeader().getCode().equalsIgnoreCase(Codes.ERROR.name())) {
                status.setCode(rs.getHeader().getCode());
                status.setDescription(rs.getHeader().getDescription());
                response.setStatus(status);
                return CompletableFuture.completedFuture(response);
            }

            List<co.edu.javeriana.external.services.bl.domain.Passenger> pasajeros = new ArrayList<>();

            for (Passenger row : rs.getInformation().getJourneys()) {
                co.edu.javeriana.external.services.bl.domain.Passenger item = new co.edu.javeriana.external.services.bl.domain.Passenger();

                item.setNombres(row.getNombres());
                item.setApellidos(row.getApellidos());
                item.setTipoDocumento(row.getTipoDocumento());
                item.setNumeroDocumento(row.getNumeroDocumento());
                item.setFecha(row.getFecha());
                item.setHora(row.getHora());
                item.setOrigen(row.getOrigen());
                item.setDestino(row.getDestino());

                pasajeros.add(item);
            }

            status.setCode(Codes.SUCCESS.name());
            status.setDescription("Passengers query has been success");
            response.setStatus(status);
            response.setPassengers(pasajeros);

            return CompletableFuture.completedFuture(response);
        } catch(Exception e) {
            e.printStackTrace();
            status.setCode(Codes.ERROR.name());
            status.setDescription(String.format("There is an error getting passenger informations : %s", e.getMessage()));
            response.setStatus(status);
            return CompletableFuture.completedFuture(response);
        }
    }
}
