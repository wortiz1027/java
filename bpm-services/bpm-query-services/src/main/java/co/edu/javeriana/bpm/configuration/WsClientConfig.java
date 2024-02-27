package co.edu.javeriana.bpm.configuration;

import co.edu.javeriana.bpm.infraestructure.client.BPMWsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WsClientConfig {

    @Value("${soap.service.bpm.url}")
    private String endpoint;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("co.edu.javeriana.bpm.infraestructure.wsdl.model");
        return marshaller;
    }

    @Bean
    public BPMWsClient bpmClient(Jaxb2Marshaller marshaller) {
        BPMWsClient client = new BPMWsClient();
        client.setDefaultUri(endpoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }

}
