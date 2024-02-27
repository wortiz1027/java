package co.edu.javeriana.external.services.paywaoint.configuration;

import co.edu.javeriana.external.services.paywaoint.infraestructure.client.CreditCardWsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WsClientConfig {

    @Value("${soap.service.paywaoint.url}")
    private String endpoint;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("co.edu.javeriana.external.services.paywaoint.infraestructure.wsdl.model");
        return marshaller;
    }

    @Bean
    public CreditCardWsClient creditCardClient(Jaxb2Marshaller marshaller) {
        CreditCardWsClient client = new CreditCardWsClient();
        client.setDefaultUri(endpoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }

}
