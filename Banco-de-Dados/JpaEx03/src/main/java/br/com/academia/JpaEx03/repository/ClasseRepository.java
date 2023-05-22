package br.com.academia.JpaEx03.repository;

import br.com.academia.JpaEx03.orm.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.print.DocFlavor;

public interface ClasseRepository extends JpaRepository<Classe, Integer>, CrudRepository<Classe, Integer> {
}
