package co.edu.javeriana.external.service.paywaoint.application;

//import co.edu.javeriana.external.service.paywaoint.domain.CreditCard;
import co.edu.javeriana.external.service.paywaoint.domain.CreditCard;
import co.edu.javeriana.external.service.paywaoint.infraestructure.repository.PayRepository;
import co.edu.javeriana.external.service.paywaoint.infraestructure.wsdl.model.ChargeCreditCardElement;
import co.edu.javeriana.external.service.paywaoint.infraestructure.wsdl.model.ChargeCreditCardResponseElement;
import co.edu.javeriana.external.service.paywaoint.infraestructure.wsdl.model.VerifyCreditCardElement;
import co.edu.javeriana.external.service.paywaoint.infraestructure.wsdl.model.VerifyCreditCardResponseElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditServicesImpl implements CreditServices{

    private final PayRepository repository;

    @Override
    public VerifyCreditCardResponseElement validateCreditCard(VerifyCreditCardElement request) {
        VerifyCreditCardResponseElement response = new VerifyCreditCardResponseElement();
        try {
            Optional<CreditCard> card = repository.findByCreditCardNumber(request.getCc().getNumber());

            if (card.isPresent()) {
                response.setResult(Boolean.TRUE);
            } else {
                response.setResult(Boolean.TRUE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public ChargeCreditCardResponseElement paymentCreditCard(ChargeCreditCardElement request) {
        Optional<CreditCard> existCard = repository.findByCreditCardNumber(request.getCc().getNumber());

        ChargeCreditCardResponseElement response = new ChargeCreditCardResponseElement();

        if (!existCard.isPresent()) {
            response.setResult(Boolean.FALSE);
            return response;
        }

        CreditCard card = new CreditCard();
        card.setType(request.getCc().getType());
        card.setNumber(request.getCc().getNumber());
        card.setAmount(new BigDecimal(request.getCc().getMount()));

        if (card.getAmount().compareTo(existCard.get().getAmount()) <= 0) {
            card.setAmount(existCard.get().getAmount().subtract(card.getAmount()));
            response.setResult(repository.chargeAmountCreditCard(card));
            return response;
        }

        response.setResult(Boolean.FALSE);
        return response;
    }
}
