package org.workshop.starter.autoconfigure;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.workshop.starter.service.ClientEncoderService;
import org.workshop.starter.service.IClientEncoder;

@Configuration
@RequiredArgsConstructor
@ConditionalOnClass({IClientEncoder.class})
@EnableConfigurationProperties({EncoderProperties.class})
public class EncoderAutoConfiguration {

    private final EncoderProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public IClientEncoder encoderConfigOne() {

        String host = properties.getHost() == null
                ? System.getenv("SERVICE_ENCODER_HOST")
                : properties.getHost();

        int port = properties.getPort() == null
                ? Integer.parseInt(System.getenv("SERVICE_ENCODER_PORT"))
                : properties.getPort();

        properties.setHost(host);
        properties.setPort(port);

        return new ClientEncoderService(properties);
    }

    @Bean
    @ConditionalOnMissingBean
    public IClientEncoder encoderConfigTwo() {
        return new ClientEncoderService(this.properties);
    }

}