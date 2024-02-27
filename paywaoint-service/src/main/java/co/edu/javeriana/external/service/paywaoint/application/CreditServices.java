package co.edu.javeriana.external.service.paywaoint.application;

import co.edu.javeriana.external.service.paywaoint.infraestructure.wsdl.model.ChargeCreditCardElement;
import co.edu.javeriana.external.service.paywaoint.infraestructure.wsdl.model.ChargeCreditCardResponseElement;
import co.edu.javeriana.external.service.paywaoint.infraestructure.wsdl.model.VerifyCreditCardElement;
import co.edu.javeriana.external.service.paywaoint.infraestructure.wsdl.model.VerifyCreditCardResponseElement;

public interface CreditServices {

    VerifyCreditCardResponseElement validateCreditCard(VerifyCreditCardElement request);
    ChargeCreditCardResponseElement paymentCreditCard(ChargeCreditCardElement request);

}
