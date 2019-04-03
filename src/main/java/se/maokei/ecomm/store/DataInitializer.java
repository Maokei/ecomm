package se.maokei.ecomm.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import se.maokei.ecomm.store.repository.UserRepository;

@Component
public class DataInitializer {

    @Autowired
    UserRepository userRepository;

    @EventListener(value = ApplicationReadyEvent.class)
    public void initiate() {
        initiateRoles();
        initiateUsers();
    }

    private void initiateRoles() {

    }

    private void initiateUsers() {

    }
}
