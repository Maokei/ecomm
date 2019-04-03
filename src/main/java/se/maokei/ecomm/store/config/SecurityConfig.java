package se.maokei.ecomm.store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import se.maokei.ecomm.store.services.UserSecurityService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private Environment environment;

    @Autowired
    private UserSecurityService userSecurityService;
    private static final String[] PUBLIC_MATCHES = {
            "/css/**", "/js/**","/image/**","/product/**","/book/**", "/user/**"

    };

    public SecurityConfig() {

    }

    private BCryptPasswordEncoder passwordEncoder() {
        return SecurityUtility.passwordEncoder();
    }

     @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable().httpBasic().and().authorizeRequests()
                .antMatchers(PUBLIC_MATCHES).permitAll().anyRequest().authenticated();
     }
}
