package co.com.sistema.sistemainformacion.config;

import co.com.sistema.sistemainformacion.utils.Constantes;
import co.com.sistema.sistemainformacion.utils.LogginAspect;
import co.com.sistema.sistemainformacion.utils.Util;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "co.com.sistema.sistemainformacion.*")
@PropertySource(value = {"classpath:jdbc.properties"})
public class ApplicationContext {
    
    @Autowired
    private Environment env;
 
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setDriverClassName(env.getRequiredProperty(Constantes.DRIVER_KEY));
        dataSource.setUrl(env.getRequiredProperty(Constantes.URL_KEY));
        dataSource.setUsername(env.getRequiredProperty(Constantes.USERNAME_KEY));
        dataSource.setPassword(Util.Desencriptar(env.getRequiredProperty(Constantes.PASSWORD_KEY)));
        
        return dataSource;
    }
 
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
    
    @Bean 
    public LogginAspect myAspect() {
        return new LogginAspect();
    }
    
}