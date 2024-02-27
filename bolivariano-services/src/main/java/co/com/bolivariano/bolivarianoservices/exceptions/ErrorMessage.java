package co.com.bolivariano.bolivarianoservices.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorMessage {

    private int errorcode;
    private String errormessage;

}
