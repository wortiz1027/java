package co.com.business.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import co.com.business.service.utils.Constantes;
import co.com.business.utils.aspectos.LogginAspect;
import net.bull.javamelody.MonitoredWithSpring;

import javax.naming.NamingException;
import javax.servlet.Filter;
import javax.servlet.http.HttpSessionListener;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan({"co.com.business.*"})
@PropertySource(value = {"classpath:jdbc.properties",
						 "classpath:oauth2.properties",
						 "classpath:application.properties",
						 "classpath:i18n/messages.properties"})
@EnableAspectJAutoProxy
@ImportResource("classpath:net/bull/javamelody/monitoring-spring-aspectj.xml")
@MonitoredWithSpring
public class ApplicationContext {
	
	@Autowired
	private Environment env;
	
	@Bean
	@MonitoredWithSpring
	public DataSource dataSourceJndi() throws NamingException {
        return (DataSource) new JndiTemplate().lookup(env.getProperty(Constantes.JNDI_DATASOURCE_KEY));
    }
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() throws NamingException{
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSourceJndi());
		sessionFactory.setPackagesToScan(new String [] {"co.com.business.repository.entities"});
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}

	private Properties getHibernateProperties() {
		Properties prop = new Properties();
		
		prop.put("hibernate.dialect", env.getProperty("mysql.dialect"));
		prop.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		prop.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		prop.put("hibernate.query.substitutions", env.getProperty("hibernate.query.substitutions"));
		prop.put("hibernate.connection.release_mode", env.getProperty("hibernate.connection.release_mode"));
		prop.put("hibernate.generate_statistics", env.getProperty("hibernate.generate_statistics"));
		prop.put("hibernate.jdbc.factory_class", env.getProperty("hibernate.jdbc.factory_class"));
		
		return prop;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {		
		HibernateTransactionManager txtManager = new HibernateTransactionManager();
		txtManager.setSessionFactory(sessionFactory);
		
		return txtManager;		
	}
	
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