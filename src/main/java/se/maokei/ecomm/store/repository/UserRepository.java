package se.maokei.ecomm.store.repository;

import org.springframework.data.repository.CrudRepository;
import se.maokei.ecomm.store.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByUsername(String username);
    Optional<User> findById(long id);
    List<User> findAll();
}
