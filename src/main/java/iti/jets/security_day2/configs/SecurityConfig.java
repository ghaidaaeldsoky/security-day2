package iti.jets.security_day2.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import iti.jets.security_day2.security.MyCustomFilter;
import iti.jets.security_day2.security.UserDetailsServiceImpl;
import jakarta.servlet.Filter;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder encoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    UserDetailsService userDetailsServiceImpl() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.httpBasic(Customizer.withDefaults());

        http.addFilterBefore(customFilter(), UsernamePasswordAuthenticationFilter.class);

        http.authorizeHttpRequests( c-> c.anyRequest().authenticated() );
        return http.build();

    }

    @Bean
    Filter customFilter() {
        return new MyCustomFilter();
    }

}
