package co.edu.javeriana.bpm.infraestructure.client;

import co.edu.javeriana.bpm.infraestructure.wsdl.model.IniciarPaqueteTuristico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class BPMWsClient extends WebServiceGatewaySupport {

    private static final Logger LOG = LoggerFactory.getLogger(BPMWsClient.class);

    public String getInstanciaBPM(co.edu.javeriana.bpm.dtos.Request rq) {
        IniciarPaqueteTuristico request = new IniciarPaqueteTuristico();
        request.setNumeroSolicitud(rq.getNumeroSolicitud());

        String response = getWebServiceTemplate().marshalSendAndReceive(request).toString();

        return response;
    }
}