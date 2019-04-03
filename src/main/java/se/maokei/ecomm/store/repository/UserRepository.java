package se.maokei.ecomm.store.repository;

import org.springframework.data.repository.CrudRepository;
import se.maokei.ecomm.store.domain.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    List<User> findAll();
}
