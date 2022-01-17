package se.maokei.ecomm.store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.password.PasswordEncoder;
import se.maokei.ecomm.store.services.UserSecurityService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private Environment environment;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserSecurityService userSecurityService;
    private static final String[] PUBLIC_MATCHES = {
            "/css/**", "/js/**","/image/**","/product/**", "/user/**"
    };

    public SecurityConfig() {

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home", "/h2", "/all", "/rest").permitAll()
                .and().csrf().ignoringAntMatchers("/h2/**")
                .and().headers().frameOptions().sameOrigin();
    }

    /*private BCryptPasswordEncoder passwordEncoder() {
        return SecurityUtility.passwordEncoder();
    }*/

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password(
                        passwordEncoder.encode("password")
                ).roles("USER");
    }
}
