//package ru.sabitov.spring3.security_config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/test").permitAll()
//                        .anyRequest().permitAll()
//                )
//                .exceptionHandling().accessDeniedHandler((request, response, accessDeniedException) -> response.sendRedirect("/403.html")).and()
//                .formLogin().loginPage("/signin").failureUrl("/signin").passwordParameter("password").usernameParameter("username").and()
//                .logout().logoutUrl("/signout").deleteCookies("JSESSIONID").and()
//                .sessionManagement().maximumSessions(2).expiredUrl("/signin");
//
//
//        return http.build();
//    }
//}
