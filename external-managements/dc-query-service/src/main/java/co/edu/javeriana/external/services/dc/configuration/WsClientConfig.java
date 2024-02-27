package co.edu.javeriana.external.services.dc.configuration;

import co.edu.javeriana.external.services.dc.infraestructure.ws.client.DanCarltonWsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WsClientConfig {

    @Value("${soap.service.dc.url}")
    private String endpoint;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("co.edu.javeriana.external.services.dc.infraestructure.ws.xsd");
        return marshaller;
    }

    @Bean
    public DanCarltonWsClient countryClient(Jaxb2Marshaller marshaller) {
        DanCarltonWsClient client = new DanCarltonWsClient();
        client.setDefaultUri(endpoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}