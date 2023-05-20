package br.com.academiaJava.JpaEx1;

import br.com.academiaJava.JpaEx1.service.CrudProfissaoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@EnableJpaRepositories
@SpringBootApplication
public class JpaEx1Application implements CommandLineRunner {
	private final CrudProfissaoService crudProfissaoService;
	private Boolean system = true;

	public JpaEx1Application(CrudProfissaoService crudProfissaoService) {
		this.crudProfissaoService = crudProfissaoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaEx1Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while(system) {
			System.out.println("Qual funcção deseja?");
			System.out.println("0 - Sair");
			System.out.println("1 - Profissão");

			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					crudProfissaoService.inicial(scanner);
					break;
				default:
					System.out.println("Finalizado.");
			}
		}
	}
}
