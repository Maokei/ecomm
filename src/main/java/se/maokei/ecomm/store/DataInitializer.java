package se.maokei.ecomm.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import se.maokei.ecomm.store.config.SecurityUtility;
import se.maokei.ecomm.store.domain.User;
import se.maokei.ecomm.store.domain.security.Role;
import se.maokei.ecomm.store.domain.security.UserRole;
import se.maokei.ecomm.store.repository.RoleRepository;
import se.maokei.ecomm.store.repository.UserRepository;
import se.maokei.ecomm.store.services.UserService;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserService userService;


    @EventListener(value = ApplicationReadyEvent.class)
    public void initiate() {
        clearRoles();
        initiateRoles();
        initiateUsers();
    }

    private void clearRoles() {
        //roleRepository.deleteAll();
        //entityManager.clear();
        //System.out.println("CLEARED ROLES");
    }

    /**
     * initiateRoles
     * Default roles
     * */
    private void initiateRoles() {
        Role admin = new Role();
        admin.setName("ROLE_ADMIN");
        if(roleRepository.findRoleByName("ROLE_ADMIN") == null)
            roleRepository.save(admin);
        Role user = new Role();
        user.setName("ROLE_USER");
        if(roleRepository.findRoleByName("ROLE_USER") == null)
            roleRepository.save(user);
    }

    /**
     * initiateUsers
     * Add test users
     * */
    private void initiateUsers() {
        this.userRepository.deleteAll();

        User user1 = new User();
        user1.setFirstName("Steve");
        user1.setLastName("Underwood");
        user1.setUsername("monarc");
        user1.setPassword(SecurityUtility.passwordEncoder().encode("test123"));
        user1.setEmail("tester@gmail.com");

        Set<UserRole> userRoles = new HashSet<>();

        Role role1 = new Role();
        //role1.setRoleId(1);
        role1.setName("ROLE_USER");
        userRoles.add(new UserRole(user1, role1));

        userService.createUser(user1, userRoles);
        userRoles.clear();

        //2:nd user
        User user2 = new User();
        user2.setFirstName("admin");
        user2.setLastName("admin");
        user2.setUsername("admin");
        user2.setPassword(SecurityUtility.passwordEncoder().encode("admin123"));
        user2.setEmail("admin@gmail.com");
        Role role2 = new Role();
        //role2.setRoleId(0);
        role2.setName("ROLE_ADMIN");
        userRoles.add(new UserRole(user2, role2));

        userService.createUser(user2, userRoles);
    }
}
