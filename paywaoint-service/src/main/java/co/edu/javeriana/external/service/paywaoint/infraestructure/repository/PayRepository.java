package co.edu.javeriana.external.service.paywaoint.infraestructure.repository;

import co.edu.javeriana.external.service.paywaoint.domain.CreditCard;

import java.util.Optional;

public interface PayRepository {

    Optional<CreditCard> findByCreditCardNumber(String number);
    boolean chargeAmountCreditCard(CreditCard card);

}
