package br.com.academiaJava.JpaEx02Ex03.service;

import br.com.academiaJava.JpaEx02Ex03.orm.Department;
import br.com.academiaJava.JpaEx02Ex03.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudDepartmentService {
    private Boolean system = true;
    private final DepartmentRepository departmentRepository;

    public CrudDepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual ação de unidade deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");

            Integer action = scanner.nextInt();

            switch (action) {
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3:
                    visualizar();
                    break;
                case 4:
                    deletar(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }
    private void salvar(Scanner scanner) {
        System.out.println("Digite o nome da unidade");
        String nome = scanner.next();

        Department department = new Department();
        department.setName(nome);


        departmentRepository.save(department);
        System.out.println("Salvo");
    }
    private void atualizar(Scanner scanner) {
        System.out.println("Digite o id");
        Integer id = scanner.nextInt();

        System.out.println("Digite o nome da unidade");
        String nome = scanner.next();

        Department department = new Department();
        department.setId(id);
        department.setName(nome);

        departmentRepository.save(department);
        System.out.println("Alterado");
    }

    private void visualizar() {
        Iterable<Department> departments = departmentRepository.findAll();
        departments.forEach(department -> System.out.println(department));
    }
    private void deletar(Scanner scanner) {
        System.out.println("Id");
        Integer id = scanner.nextInt();
        departmentRepository.deleteById(id);
        System.out.println("Deletado");
    }
}
