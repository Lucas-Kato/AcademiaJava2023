package academiaJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.management.remote.JMXServerErrorException;
import javax.naming.NamingException;

@EnableScheduling
@SpringBootApplication
public class DemoApplication {

	public static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) throws NamingException, JMXServerErrorException {
		logger.info("Iniciando a api de cadastro de pessoas");
		SpringApplication.run(DemoApplication.class, args);
		logger.info("API de cadastro de pessoas iniciada e pronta para receber requisições");

	}

}
