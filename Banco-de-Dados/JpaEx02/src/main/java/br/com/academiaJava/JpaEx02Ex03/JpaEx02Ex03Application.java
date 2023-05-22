package br.com.academiaJava.JpaEx02Ex03;

import br.com.academiaJava.JpaEx02Ex03.service.CrudDepartmentService;
import br.com.academiaJava.JpaEx02Ex03.service.CrudEmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;
@EnableJpaRepositories
@SpringBootApplication
public class JpaEx02Ex03Application implements CommandLineRunner {
	private final CrudEmployeeService crudEmployeeService;
	private final CrudDepartmentService crudDepartmentService;
	private Boolean system = true;

	public JpaEx02Ex03Application(CrudDepartmentService crudDepartmentService, CrudEmployeeService crudEmployeeService) {
		this.crudDepartmentService = crudDepartmentService;
		this.crudEmployeeService = crudEmployeeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaEx02Ex03Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (system ) {
			System.out.println("Qual ação você quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Funcionário");
			System.out.println("2 - Unidade");


			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					crudDepartmentService.inicial(scanner);
					break;
				case 2:
					crudEmployeeService.inicial(scanner);
					break;
				default:
					System.out.println("Finalizando");

			}
		}
	}

}
