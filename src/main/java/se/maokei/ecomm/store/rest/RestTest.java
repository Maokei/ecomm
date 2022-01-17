package se.maokei.ecomm.store.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import se.maokei.ecomm.store.domain.User;
import se.maokei.ecomm.store.domain.security.Role;
import se.maokei.ecomm.store.domain.security.UserRole;
import se.maokei.ecomm.store.repository.UserRepository;
import se.maokei.ecomm.store.services.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@RequestMapping("/api/users")
@RestController
public class RestTest {
  @Autowired
  UserService userService;
  @Autowired
  UserRepository userRepository;
  @Autowired
  PasswordEncoder passwordEncoder;

  @GetMapping("/all")
  private List<User> getAllUsers() {
    List<User> users = userRepository.findAll();
    System.out.println(users);
    return users;
  }

  @GetMapping("/rest")
  private String rest() {
    return "rest hello";
  }

  @GetMapping("/add")
  private String add() {
    User user1 = new User();
    user1.setFirstName("Steve");
    user1.setLastName("Underwood");
    user1.setUsername("box");
    user1.setPassword(passwordEncoder.encode("test123"));
    user1.setEmail("tester@gmail.com");

    Set<UserRole> userRoles = new HashSet<>();

    Role role1 = new Role();
    role1.setName("ROLE_USER");
    userRoles.add(new UserRole(user1, role1));

    userRepository.save(user1);
    return "added";
  }
}
