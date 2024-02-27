package co.edu.javeriana.external.services.paywaoint.dtos;

import co.edu.javeriana.external.services.paywaoint.domain.CreditCard;
import lombok.Data;

@Data
public class Request implements java.io.Serializable {

    protected CreditCard creditCard;

}
