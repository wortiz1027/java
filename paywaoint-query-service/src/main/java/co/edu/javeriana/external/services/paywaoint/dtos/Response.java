package co.edu.javeriana.external.services.paywaoint.dtos;

import lombok.Data;

@Data
public class Response implements java.io.Serializable {

    private Status status;
    private boolean result;

}
