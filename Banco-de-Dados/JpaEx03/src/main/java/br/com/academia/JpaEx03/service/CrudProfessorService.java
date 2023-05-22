package br.com.academia.JpaEx03.service;

import br.com.academia.JpaEx03.orm.Professor;
import br.com.academia.JpaEx03.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudProfessorService {
    private Boolean system = true;
    private final ProfessorRepository professorRepository;

    public CrudProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual ação deseja executar?");
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
                    atualiar(scanner);
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
        System.out.println("ID");
        Integer tid = scanner.nextInt();

        System.out.println("Nome do professor");
        String tnome = scanner.next();

        System.out.println("Área de ensino");
        String assunto = scanner.next();

        Professor professor = new Professor();
        professor.setTid(tid);
        professor.setTnome(tnome);
        professor.getAssunto(assunto);

        professorRepository.save(professor);
        System.out.println("Salvo");
    }
    private void atualiar(Scanner scanner) {
        System.out.println("Id");
        Integer tid = scanner.nextInt();

        System.out.println("Nome");
        String tnome = scanner.next();

        System.out.println("ÁREA");
        String assunto = scanner.next();

        Professor professor = new Professor();
        professor.setTid(tid);
        professor.setTnome(tnome);
        professor.setAssunto(assunto);

        professorRepository.save(professor);
        System.out.println("Alterado");
    }

    private void visualizar() {
        Iterable<Professor> professors = professorRepository.findAll();
        professors.forEach(professor -> System.out.println(professor));
    }

    private void deletar(Scanner scanner) {
        System.out.println("ID");
        Integer tid = scanner.nextInt();

        professorRepository.deleteById(tid);
        System.out.println("Deletado");
    }
}
