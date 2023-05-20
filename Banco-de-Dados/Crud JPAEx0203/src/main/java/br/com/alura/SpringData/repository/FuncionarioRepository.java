package br.com.alura.SpringData.repository;

import br.com.alura.SpringData.orm.Cargo;
import br.com.alura.SpringData.orm.Funcionario;
import br.com.alura.SpringData.orm.FuncionarioProjecao;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>, JpaSpecificationExecutor<Funcionario>, CrudRepository<Funcionario, Integer> {
    List<Funcionario> findByNome(String nome);

    @Query("SELECT f from Funcionario  f where f.nome = :nome " + "and f.salario >= :salario and f.dataContratacao = :data")
    List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate data);

    @Query(value = "select * from funcionarios f where f.data_contratacao >= :data", nativeQuery = true)
    List<Funcionario> findDataContratacaoMaior(LocalDate data);

    @Query(value = "select f.id, f.nome, f.salario from funcionarios f", nativeQuery = true)
    List<FuncionarioProjecao> findFuncionarioSalario();
}
