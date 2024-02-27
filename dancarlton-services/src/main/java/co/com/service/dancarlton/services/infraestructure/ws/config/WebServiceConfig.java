package co.com.service.dancarlton.services.infraestructure.ws.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }

    @Bean(name = "reservas")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema journeySchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("reservasPort");
        definition.setTargetNamespace("http://co.dancarlton.com/reservas");
        definition.setLocationUri("/ws");
        definition.setSchema(journeySchema);
        return definition;
    }

    @Bean
    public XsdSchema flightSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/reservas.xsd"));
    }

}