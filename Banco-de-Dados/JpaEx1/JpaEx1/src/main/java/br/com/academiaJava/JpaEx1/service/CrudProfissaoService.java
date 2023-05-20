package br.com.academiaJava.JpaEx1.service;

import br.com.academiaJava.JpaEx1.cargoRepository.profissaoRepository;
import br.com.academiaJava.JpaEx1.orm.Profissao;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudProfissaoService {
    private Boolean system = true;
    private final profissaoRepository profissaoRepository;


    public CrudProfissaoService(profissaoRepository profissaoRepository) {
        this.profissaoRepository = profissaoRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Insira o comando.");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar.");
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
        System.out.println("Qual área do profissional?");
        String area = scanner.next();
        Profissao profissao = new Profissao();
        profissao.setArea(area);
        profissaoRepository.save(profissao);


        System.out.println("Salvo com sucesso.");
    }
    private void atualizar(Scanner scanner) {
        System.out.println("Insira ID do profissional que vai ser tranferido.");
        Long id =scanner.nextLong();
        System.out.println("Qual área vai ser realocado?.");
        String area = scanner.next();
        Profissao profissao = new Profissao();
        profissao.setId(id);
        profissao.setArea(area);
        profissaoRepository.save(profissao);

        System.out.println("Foi realocado com sucesso.");
    }
    private void visualizar() {
        Iterable<Profissao> profissaos = profissaoRepository.findAll();
        profissaos.forEach(profissao -> System.out.println(profissao));
    }
    private void deletar(Scanner scanner) {
        System.out.println("Insira o ID para remoção");
        Long id = scanner.nextLong();
        profissaoRepository.deleteById(id);

        System.out.println("Removido com sucesso.");
    }
}
