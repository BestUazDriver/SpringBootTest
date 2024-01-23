package ru.sabitov.springboottest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import ru.sabitov.springboottest.listeners.SessionListener;
import ru.sabitov.springboottest.security.details.AccountUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableJdbcHttpSession(maxInactiveIntervalInSeconds = 60 * 60 * 24)
public class SecurityConfig {

    @Autowired
    private AccountUserDetailsService accountUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .formLogin((customizer) -> customizer.loginPage("/login").defaultSuccessUrl("/test").failureUrl("/login?error").permitAll())
                .userDetailsService(accountUserDetailsService)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/test").permitAll()
                        .requestMatchers("/login*").permitAll()
                        .requestMatchers("/login**").permitAll()
                        .requestMatchers("/signin*").permitAll()
                        .anyRequest().permitAll()
                )
                .logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer.logoutSuccessUrl("/login").logoutUrl("/signout").permitAll().invalidateHttpSession(true));
        return http.build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ServletListenerRegistrationBean<SessionListener> sessionListenerBean() {
        return new ServletListenerRegistrationBean<>(new SessionListener());
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
