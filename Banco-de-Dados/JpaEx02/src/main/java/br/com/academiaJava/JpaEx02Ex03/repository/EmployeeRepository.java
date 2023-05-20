package br.com.academiaJava.JpaEx02Ex03.repository;

import br.com.academiaJava.JpaEx02Ex03.orm.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer>, CrudRepository<Employee, Integer> {
}
