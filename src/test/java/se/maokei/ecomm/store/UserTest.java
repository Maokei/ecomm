package se.maokei.ecomm.store;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.maokei.ecomm.store.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    private User user;

    @Before
    private void setup() {
        user = new User();

    }

    @Test
    public void test() {

    }
}
