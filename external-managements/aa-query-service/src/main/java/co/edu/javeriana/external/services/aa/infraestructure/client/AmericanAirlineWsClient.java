package co.edu.javeriana.external.services.aa.infraestructure.client;

import co.edu.javeriana.external.services.aa.dtos.all.Request;
import co.edu.javeriana.external.services.aa.infraestructure.wsdl.model.GetAllFlightsRequest;
import co.edu.javeriana.external.services.aa.infraestructure.wsdl.model.GetAllFlightsResponse;
import co.edu.javeriana.external.services.aa.infraestructure.wsdl.model.GetFlightsRequest;
import co.edu.javeriana.external.services.aa.infraestructure.wsdl.model.GetFlightsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class AmericanAirlineWsClient extends WebServiceGatewaySupport {

    private static final Logger LOG = LoggerFactory.getLogger(AmericanAirlineWsClient.class);

    public GetAllFlightsResponse getAllFlights(Request rq) {
        GetAllFlightsRequest request = new GetAllFlightsRequest();
        request.setAvailable(rq.getAvailable());
        LOG.debug("REQUEST >> {}", request.getAvailable());
        GetAllFlightsResponse response = (GetAllFlightsResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        LOG.debug("RESPONSE >> {}", response);

        if (response.getHeader() != null) LOG.debug("DESCRIPTION: {}", response.getHeader().getDescription());
        return response;
    }

    public GetFlightsResponse getFlight(co.edu.javeriana.external.services.aa.dtos.flight.Request rq) {
        GetFlightsRequest request = new GetFlightsRequest();
        request.setCity(rq.getCity());
        LOG.debug("REQUEST >> {}", request.getCity());
        GetFlightsResponse response = (GetFlightsResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        LOG.debug("RESPONSE >> {}", response);

        return response;
    }

}
