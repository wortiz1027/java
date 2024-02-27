package co.com.securityserver.security.extra;


import co.com.securityserver.utils.aspects.LogginAspect;
import org.springframework.context.annotation.*;

import javax.servlet.Filter;
import javax.servlet.http.HttpSessionListener;

@Configuration
@EnableAspectJAutoProxy
public class ApplicationExtraConfig {

    @Bean
    public LogginAspect myAspect() {
        return new LogginAspect();
    }

    @Bean
    public HttpSessionListener javaMelodyListener(){
        return new net.bull.javamelody.SessionListener();
    }

    @Bean
    public Filter javaMelodyFilter(){
        return new net.bull.javamelody.MonitoringFilter();
    }

}
