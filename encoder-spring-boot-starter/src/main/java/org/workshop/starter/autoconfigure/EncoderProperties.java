package org.workshop.starter.autoconfigure;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties(prefix = "service.encoder")
public class EncoderProperties {

    private String host;
    private Integer port;
    private String algorithm;

}