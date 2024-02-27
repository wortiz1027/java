package co.edu.javeriana.bpm.infraestructure.client;

import co.edu.javeriana.bpm.infraestructure.wsdl.model.cancelar.CancelarProceso;
import co.edu.javeriana.bpm.infraestructure.wsdl.model.cancelar.CancelarProcesoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class BPMCancelClient extends WebServiceGatewaySupport {

    private static final Logger LOG = LoggerFactory.getLogger(BPMWsClient.class);

    public CancelarProcesoResponse getCancelarBPM(co.edu.javeriana.bpm.dtos.Request rq) {
        CancelarProcesoResponse response = new CancelarProcesoResponse();
        CancelarProceso request = new CancelarProceso();

        request.setNumeroSolicitud(rq.getNumeroSolicitud());
        response = (CancelarProcesoResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        return response;
    }

}
