package co.edu.javeriana.external.service.paywaoint.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {

    private String id;
    private String type;
    private String number;
    private BigDecimal amount;

}
