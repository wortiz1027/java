package co.com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
		                            DataSourceTransactionManagerAutoConfiguration.class,
									HibernateJpaAutoConfiguration.class})
public class SpringbootdockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdockerApplication.class, args);
	}
}
