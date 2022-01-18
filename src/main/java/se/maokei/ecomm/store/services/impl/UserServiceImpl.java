package se.maokei.ecomm.store.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.maokei.ecomm.store.domain.User;
import se.maokei.ecomm.store.domain.security.Role;
import se.maokei.ecomm.store.domain.security.UserRole;
import se.maokei.ecomm.store.repository.RoleRepository;
import se.maokei.ecomm.store.repository.UserRepository;
import se.maokei.ecomm.store.services.UserService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Transactional
    public Optional<User> createUser(User user, Set<UserRole> userRoles) {
        Optional<User> userOpt = userRepository.findUserByEmail(user.getEmail());

        if(userOpt.isPresent()) {
            LOGGER.info("A user with the email {} already exists.", user.getEmail());
        }else{
            Set<UserRole> localUserRoles = new HashSet<>();
            for(UserRole ur : userRoles) {
                Role role = roleRepository.findRoleByName(ur.getRole().getName());
                if(role != null)
                    localUserRoles.add(new UserRole(user, role));
            }
            //user.getUserRoles().addAll(userRoles);
            //user.setUserRoles(userRoles);
            user.setEnabled(false);
            user.setUserRoles(localUserRoles);
            return Optional.of(userRepository.save(user));
        }

        return userOpt;
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }
}
