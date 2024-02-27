package co.edu.javeriana.external.services.dc.infraestructure.ws.client;

import co.edu.javeriana.external.services.dc.dtos.all.Request;
import co.edu.javeriana.external.services.dc.infraestructure.ws.xsd.GetReservasByCodigoRequest;
import co.edu.javeriana.external.services.dc.infraestructure.ws.xsd.GetReservasByCodigoResponse;
import co.edu.javeriana.external.services.dc.infraestructure.ws.xsd.GetReservasRequest;
import co.edu.javeriana.external.services.dc.infraestructure.ws.xsd.GetReservasResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class DanCarltonWsClient extends WebServiceGatewaySupport {

    private static final Logger LOG = LoggerFactory.getLogger(DanCarltonWsClient.class);

    public GetReservasResponse getAllBookings(Request rq) {
        GetReservasRequest request = new GetReservasRequest();
        request.setKey(rq.getKey());

        GetReservasResponse response = (GetReservasResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        if (response.getHeader() != null) LOG.info("DESCRIPTION: {}", response.getHeader().getDescription());
        return response;
    }

    public GetReservasByCodigoResponse getBookingsByCode(co.edu.javeriana.external.services.dc.dtos.code.Request rq) {
        GetReservasByCodigoRequest request = new GetReservasByCodigoRequest();
        request.setKey(rq.getCode());

        GetReservasByCodigoResponse response = (GetReservasByCodigoResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        if (response.getHeader() != null) LOG.info("DESCRIPTION: {}", response.getHeader().getDescription());
        return response;
    }

}
