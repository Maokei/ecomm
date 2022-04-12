package se.maokei.ecomm.store.command;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class LoginCommand {
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 4, message="Password length has to be more than 3 characters")
    private String password;

    @Override
    public String toString() {
        return "LoginCommand{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
