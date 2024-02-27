package co.edu.javeriana.bpm.configuration;

import co.edu.javeriana.bpm.infraestructure.client.BPMCancelClient;
import co.edu.javeriana.bpm.infraestructure.client.BPMWsClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WsClientConfig {

    @Value("${soap.service.bpm.init-instance.url}")
    private String endpointInit;

    @Value("${soap.service.bpm.cancel-instance.url}")
    private String endpointCancel;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("co.edu.javeriana.bpm.infraestructure.wsdl.model");
        return marshaller;
    }

    @Bean
    public BPMWsClient bpmClient(Jaxb2Marshaller marshaller) {
        BPMWsClient client = new BPMWsClient();
        client.setDefaultUri(endpointInit);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }

    @Bean
    public Jaxb2Marshaller marshallerCancel() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("co.edu.javeriana.bpm.infraestructure.wsdl.model.cancelar");
        return marshaller;
    }

    @Bean
    public BPMCancelClient bpmCancelClient(@Qualifier("marshallerCancel") Jaxb2Marshaller marshaller) {
        BPMCancelClient client = new BPMCancelClient();
        client.setDefaultUri(endpointCancel);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }

}
