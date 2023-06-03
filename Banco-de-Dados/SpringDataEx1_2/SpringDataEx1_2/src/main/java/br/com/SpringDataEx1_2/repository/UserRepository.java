package br.com.SpringDataEx1_2.repository;

import br.com.SpringDataEx1_2.orm.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findBySobrenome(String sobrenome);
    User findById(long id);
}
