package br.com.academia.JpaEx03.service;

import br.com.academia.JpaEx03.orm.Classe;
import br.com.academia.JpaEx03.repository.ClasseRepository;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

@Service
public class CrudClasseService {
    private Boolean system = true;
    private final ClasseRepository classeRepository;

    public CrudClasseService(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual ação de deseja executar?");
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
        System.out.println("ID da classe");
        Integer cid = scanner.nextInt();

        System.out.println("Nome da classe");
        String cnome = scanner.next();

        Classe classe = new Classe();
        classe.setCid(cid);
        classe.setCnome(cnome);
        classeRepository.save(classe);
        System.out.println("Salvo");

    }

    private void atualiar(Scanner scanner) {
        System.out.println("Id da classe");
        Integer cid = scanner.nextInt();

        System.out.println("Nome da classe");
        String cnome = scanner.next();

        Classe classe = new Classe();
        classe.setCid(cid);
        classe.setCnome(cnome);
        classeRepository.save(classe);
        System.out.println("Atualizado");
    }

    private void visualizar() {
        Iterable<Classe> classeIterable = classeRepository.findAll();
        classeIterable.forEach(classe -> System.out.println(classe));
    }

    private void deletar(Scanner scanner){
        System.out.println("ID da classe");
        Integer cid = scanner.nextInt();
        classeRepository.deleteById(cid);

        System.out.println("Deletado.");
    }

}
