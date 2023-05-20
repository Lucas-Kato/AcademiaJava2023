package br.com.academiaJava.JpaEx02Ex03.repository;

import br.com.academiaJava.JpaEx02Ex03.orm.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
}
