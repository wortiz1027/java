package co.edu.javeriana.external.service.paywaoint.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/payments/ws/*");
    }

    @Bean(name = "CreditCardService")
    public Wsdl11Definition wsdl11Definition(){
        SimpleWsdl11Definition simpleWsdl11Definition = new SimpleWsdl11Definition();
        simpleWsdl11Definition.setWsdl(new ClassPathResource("/wsdl/CreditCardService.wsdl"));
        return simpleWsdl11Definition;
    }

}
