package co.edu.javeriana.external.services.paywaoint.infraestructure.client;

import co.edu.javeriana.external.services.paywaoint.dtos.Request;
import co.edu.javeriana.external.services.paywaoint.infraestructure.wsdl.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CreditCardWsClient extends WebServiceGatewaySupport {

    private static final Logger LOG = LoggerFactory.getLogger(CreditCardWsClient.class);

    public VerifyCreditCardResponseElement getVerifyCreditCard(Request rq) {
        VerifyCreditCardElement request = new VerifyCreditCardElement();
        CreditCard requestTemp = new CreditCard();
        requestTemp.setMount(rq.getCreditCard().getMount());
        requestTemp.setNumber(rq.getCreditCard().getNumber());
        requestTemp.setType(rq.getCreditCard().getType());

        request.setCc(requestTemp);

        VerifyCreditCardResponseElement response = (VerifyCreditCardResponseElement) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

    public ChargeCreditCardResponseElement setChargeCreditCard(Request rq) {
        ChargeCreditCardElement request = new ChargeCreditCardElement();
        CreditCard requestTemp = new CreditCard();
        requestTemp.setMount(rq.getCreditCard().getMount());
        requestTemp.setNumber(rq.getCreditCard().getNumber());
        requestTemp.setType(rq.getCreditCard().getType());

        request.setCc(requestTemp);

        ChargeCreditCardResponseElement response = (ChargeCreditCardResponseElement) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

}
