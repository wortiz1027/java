package co.edu.javeriana.external.services.aa.configuration;

import co.edu.javeriana.external.services.aa.infraestructure.client.AmericanAirlineWsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WsClientConfig {

    private static final Logger LOG = LoggerFactory.getLogger(WsClientConfig.class);

    @Value("${soap.service.aa.url}")
    private String endpoint;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("co.edu.javeriana.external.services.aa.infraestructure.wsdl.model");
        return marshaller;
    }

    @Bean
    public AmericanAirlineWsClient countryClient(Jaxb2Marshaller marshaller) {
        LOG.debug("ENDPOINT >> {}", endpoint);
        AmericanAirlineWsClient client = new AmericanAirlineWsClient();
        client.setDefaultUri(endpoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
