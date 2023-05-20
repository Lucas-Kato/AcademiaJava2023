package br.com.academiaJava.JpaEx1.cargoRepository;

import br.com.academiaJava.JpaEx1.orm.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface profissaoRepository extends JpaRepository<Profissao, Long>,CrudRepository<Profissao, Long> {
}
