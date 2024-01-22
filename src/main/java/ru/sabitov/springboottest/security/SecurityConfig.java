package ru.sabitov.springboottest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.sabitov.springboottest.security.details.AccountUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AccountUserDetailsService accountUserDetailsService;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authenticationProvider(authenticationProvider)
                .formLogin((customizer) -> customizer.loginPage("/login").defaultSuccessUrl("/test").failureUrl("/login?error").permitAll())
                .userDetailsService(accountUserDetailsService)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/test").permitAll()
                        .requestMatchers("/login*").permitAll()
                        .requestMatchers("/login**").permitAll()
                        .requestMatchers("/signin*").permitAll()
                        .anyRequest().permitAll()
                );
        return http.build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
