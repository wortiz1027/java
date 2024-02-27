package co.edu.javeriana.external.services.bl.infraestructure.client;

import co.edu.javeriana.external.services.bl.dtos.Request;
import co.edu.javeriana.external.services.bl.infraestructure.wsdl.model.GetJourneyRequest;
import co.edu.javeriana.external.services.bl.infraestructure.wsdl.model.GetJourneyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class BolivarianoWsClient extends WebServiceGatewaySupport {

    private static final Logger LOG = LoggerFactory.getLogger(BolivarianoWsClient.class);

    public GetJourneyResponse getAllJourneys(Request rq) {
        GetJourneyRequest request = new GetJourneyRequest();
        request.setKey(rq.getKey());

        GetJourneyResponse response = (GetJourneyResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        if (response.getHeader() != null) LOG.info("DESCRIPTION: {}", response.getHeader().getDescription());
        return response;
    }

}
