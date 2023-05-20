package br.com.academia.JpaEx03.repository;

import br.com.academia.JpaEx03.orm.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>, CrudRepository<Professor, Integer> {
}
