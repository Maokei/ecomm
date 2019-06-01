package se.maokei.ecomm.store.repository;

import org.springframework.data.repository.CrudRepository;
import se.maokei.ecomm.store.domain.security.Role;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long>{
    List<Role> findAll();
    Role findRoleByName(String name);
}
