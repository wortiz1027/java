package co.edu.javeriana.external.services.bl.configuration;

import co.edu.javeriana.external.services.bl.infraestructure.client.BolivarianoWsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WsClientConfig {

    @Value("${soap.service.bl.url}")
    private String endpoint;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("co.edu.javeriana.external.services.bl.infraestructure.wsdl.model");
        return marshaller;
    }

    @Bean
    public BolivarianoWsClient countryClient(Jaxb2Marshaller marshaller) {
        BolivarianoWsClient client = new BolivarianoWsClient();
        client.setDefaultUri(endpoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}