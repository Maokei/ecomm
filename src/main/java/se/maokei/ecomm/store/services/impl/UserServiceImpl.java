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
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Transactional
    public User createUser(User user, Set<UserRole> userRoles) {
        User localUser = userRepository.findUserByUsername(user.getUsername());

        if(localUser != null) {
            LOGGER.info("A user with the username {} already exists.", user.getUsername());
        }else{
            Set<UserRole> localUserRoles = new HashSet<>();
            for(UserRole ur : userRoles) {
                //roleRepository.save(ur.getRole());
                Role role = roleRepository.findRoleByName(ur.getRole().getName());
                if(role != null)
                    localUserRoles.add(new UserRole(user, role));
            }
            //user.getUserRoles().addAll(userRoles);
            //user.setUserRoles(userRoles);
            user.setEnabled(true);
            user.setUserRoles(localUserRoles);
            localUser = userRepository.save(user);
        }

        return localUser;
    }
}
