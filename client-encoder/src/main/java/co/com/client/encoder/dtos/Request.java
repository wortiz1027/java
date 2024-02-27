package co.com.client.encoder.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Request {

    private String algotihm;
    private String password;

}