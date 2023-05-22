package br.com.academia.JpaEx03;

import br.com.academia.JpaEx03.service.CrudClasseService;
import br.com.academia.JpaEx03.service.CrudProfessorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@EnableJpaRepositories
@SpringBootApplication
public class JpaEx03Application implements CommandLineRunner {
	private final CrudClasseService crudClasseService;
	private final CrudProfessorService crudProfessorService;
	private Boolean system = true;

	public JpaEx03Application(CrudClasseService crudClasseService, CrudProfessorService crudProfessorService) {
		this.crudClasseService = crudClasseService;
		this.crudProfessorService = crudProfessorService;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaEx03Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (system) {
			System.out.println("Qual ação você quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Classe");
			System.out.println("2 - Professor");

			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					crudClasseService.inicial(scanner);
					break;
				case 2:
					crudProfessorService.inicial(scanner);
					break;
				default:
					System.out.println("Finalizado.");
			}
		}

	}
}
