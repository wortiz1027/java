package co.edu.javeriana.external.services.avianca.configuration;

import co.edu.javeriana.external.services.avianca.infraestructure.client.AviancaWsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ConsumerConfig {

    @Value("${soap.service.avianca.url}")
    private String endpoint;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("co.edu.javeriana.external.services.avianca.infraestructure.wsdl.model");
        return marshaller;
    }

    @Bean
    public AviancaWsClient countryClient(Jaxb2Marshaller marshaller) {
        AviancaWsClient client = new AviancaWsClient();
        client.setDefaultUri(endpoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
