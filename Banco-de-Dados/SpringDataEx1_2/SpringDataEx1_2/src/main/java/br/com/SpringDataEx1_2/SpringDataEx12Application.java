package br.com.SpringDataEx1_2;

import br.com.SpringDataEx1_2.orm.User;
import br.com.SpringDataEx1_2.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataEx12Application {

	private static final Logger log = LoggerFactory.getLogger(SpringDataEx12Application.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringDataEx12Application.class, args);
	}

	@Bean
	public CommandLineRunner runner(UserRepository repository) {
		return (args -> {
		repository.save(new User("Bob", "Carlos"));
		repository.save(new User("Lucas", "Kato"));
		repository.save(new User("Ghabriel", "Russo"));
		repository.save(new User("Luiz", "Spolador"));
		repository.save(new User("Daniel", "Cupido"));
		repository.save(new User("Matheus", "O covarde"));

		log.info("Usuário cadastrado:");
		log.info("-------------------");
		for (User user : repository.findAll()){
			log.info(user.toString());
		}
		log.info("");

		User user = repository.findById(1L);
		log.info("Usuário encontrado com ID:");
		log.info("--------------------------");
		log.info(user.toString());
		log.info("");

		log.info("Usuário encontrado com sobrenome:");
		log.info("---------------------------------");
		repository.findBySobrenome("Russo").forEach(russo -> {
		log.info(russo.toString());

		});
		log.info("");
		});
	}
}
