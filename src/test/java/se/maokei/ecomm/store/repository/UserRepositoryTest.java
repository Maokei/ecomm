package se.maokei.ecomm.store.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.maokei.ecomm.store.domain.User;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {
  private final static String USERNAME_ONE = "Kitty";
  private final static String USERNAME_TWO = "storm";

  @Autowired
  UserRepository userRepository;

  @BeforeEach
  void setup() {
    userRepository.deleteAll();
    User user = new User();
    user.setUsername(USERNAME_ONE);
    user.setPassword("test123");
    user.setFirstName("Tom");
    user.setLastName("Wood");
    user.setEmail("test@email.com");
    userRepository.save(user);
    User user2 = new User();
    user2.setUsername(USERNAME_TWO);
    user2.setPassword("test1234");
    user2.setFirstName("Tommy");
    user2.setLastName("Woody");
    user2.setEmail("test2@email.com");
    userRepository.save(user2);
  }

  @Test
  public void findUserOneTest() {
    assertThat(
            userRepository.findUserByUsername(USERNAME_ONE).isPresent()
    ).isTrue();
  }

  @Test
  public void should_find_all_users() {
    assertThat((long) userRepository.findAll().size()).isEqualTo(2);
  }

  @Test
  public void should_delete_user() {
    Optional<User> opt = userRepository.findUserByUsername(USERNAME_TWO);
    assertThat(opt.isPresent()).isTrue();

    userRepository.delete(opt.get());

    assertThat(userRepository.findById(opt.get().getId()).isPresent()).isFalse();
  }
}
