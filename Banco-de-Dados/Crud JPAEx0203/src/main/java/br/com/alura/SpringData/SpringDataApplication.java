package br.com.alura.SpringData;

import br.com.alura.SpringData.orm.Cargo;
import br.com.alura.SpringData.repository.CargoRepository;
import br.com.alura.SpringData.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;
@EnableJpaRepositories
@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	private final CrudCargoService crudCargoService;
	private final RelatorioService relatorioService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;
	private Boolean system = true;

	public SpringDataApplication(CrudCargoService crudCargoService, RelatorioService relatorioService, CrudFuncionarioService funcionarioService, CrudUnidadeTrabalhoService unidadeTrabalhoService, RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
		this.crudCargoService = crudCargoService;
		this.relatorioService = relatorioService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (system ) {
			System.out.println("Qual ação você quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionário");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatorios");
			System.out.println("5 - Relatório dinamico");

			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					crudCargoService.inicial(scanner);
					break;
				case 2:
					funcionarioService.inicial(scanner);
					break;
				case 3:
					unidadeTrabalhoService.inicial(scanner);
					break;
				case 4:
					relatorioService.inicial(scanner);
					break;
				case 5:
					relatorioFuncionarioDinamico.inicial(scanner);
					break;
				default:
					System.out.println("Finalizando");

			}
		}
	}
}
