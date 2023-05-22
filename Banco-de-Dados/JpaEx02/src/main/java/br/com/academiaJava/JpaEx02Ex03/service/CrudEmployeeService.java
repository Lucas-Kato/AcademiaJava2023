package br.com.academiaJava.JpaEx02Ex03.service;


import br.com.academiaJava.JpaEx02Ex03.orm.Employee;
import br.com.academiaJava.JpaEx02Ex03.repository.DepartmentRepository;
import br.com.academiaJava.JpaEx02Ex03.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudEmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private Boolean system = true;

    public CrudEmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual ação de funcionario deseja executar");
            System.out.println("0 - Sair.");
            System.out.println("1 - Salvar.");
            System.out.println("2 - Atualizar.");
            System.out.println("3 - Visualizar.");
            System.out.println("4 - Deletar.");

            Integer action = scanner.nextInt();

            switch (action) {
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualiar(scanner);
                    break;
                case 3:
                    visualizar();
                    break;


            }
        }
    }
    private void salvar(Scanner scanner) {
        System.out.println("Qual nome do employee");
        String ename = scanner.next();
        Employee employee = new Employee();
        employee.setEname(ename);
        employeeRepository.save(employee);
        System.out.println("Salvo.");
    }

    private void atualiar(Scanner scanner) {
        System.out.println("Id");
        Integer id = scanner.nextInt();
        System.out.println("Descrição do Cargo");
        String descricao = scanner.next();
        Employee cargo = new Employee();
        cargo.setEid(id);
        cargo.setDeg(descricao);
        employeeRepository.save(cargo);
        System.out.println("Atualizado");
    }
    private void visualizar() {
        Iterable<Employee> cargos = employeeRepository.findAll();
        cargos.forEach(cargo -> System.out.println(cargo));
    }
    private void deletar(Scanner scanner) {
        System.out.println("Id");
        Integer id = scanner.nextInt();
        employeeRepository.deleteById(id);
        System.out.println("Deletado");
    }


}
