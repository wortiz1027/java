package co.edu.javeriana.external.services.paywaoint.domain;

import lombok.Data;

@Data
public class CreditCard implements java.io.Serializable{

    private String number;
    private String type;
    private Double mount;

}
