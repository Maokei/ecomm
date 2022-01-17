package se.maokei.ecomm.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SecurityUtility {
    private static final String SALT = "salt";

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        //return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
    }

    @Bean
    public static String randomPassword() {
        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXY1234567890#@$+";
        StringBuilder newPassword = new StringBuilder();
        Random rand = new Random();
        while(newPassword.length() < 18) {
            int index = (int) (rand.nextFloat() * characterSet.length());
            newPassword.append(characterSet.charAt(index));
        }
        return newPassword.toString();
    }
}
