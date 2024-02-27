package co.edu.javeriana.external.services.cc.infraestructure.client;

import co.edu.javeriana.external.services.cc.dtos.Request;

import co.edu.javeriana.external.services.cc.infraestructure.wsdl.model.GetCreditCardValidationRequest;
import co.edu.javeriana.external.services.cc.infraestructure.wsdl.model.GetCreditCardValidationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CreditCardValidationWsClient extends WebServiceGatewaySupport {

    private static final Logger LOG = LoggerFactory.getLogger(CreditCardValidationWsClient.class);

    public GetCreditCardValidationResponse getCreditCardValidation(Request rq) {
        GetCreditCardValidationRequest request = new GetCreditCardValidationRequest();
        request.setNumber(rq.getNumber());

        GetCreditCardValidationResponse response = (GetCreditCardValidationResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

}