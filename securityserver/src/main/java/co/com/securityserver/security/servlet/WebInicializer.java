package co.com.securityserver.security.servlet;

import co.com.securityserver.SecurityserverApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class WebInicializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SecurityserverApplication.class);
    }

}