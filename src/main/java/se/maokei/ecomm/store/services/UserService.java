package se.maokei.ecomm.store.services;

import se.maokei.ecomm.store.domain.User;
import se.maokei.ecomm.store.domain.security.UserRole;

import java.util.Set;

public interface UserService {
    User createUser(User user, Set<UserRole> userRoles);
}
