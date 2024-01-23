package ru.sabitov.springboottest.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sabitov.springboottest.models.User;
import ru.sabitov.springboottest.security.AccountAuthSuccessHandler;
import ru.sabitov.springboottest.security.details.AccountUserDetails;
import ru.sabitov.springboottest.services.UserService;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class SignInController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccountAuthSuccessHandler authenticationSuccessHandler;

    @GetMapping
    public String showLoginPage(){
        return "login";
    }

    @SneakyThrows
    @GetMapping("/auth")
    public String authenticateUser(HttpServletRequest request, HttpServletResponse response){
        Optional<Cookie> oldSessionCookie = Arrays.stream(request.getCookies()).filter(cookie -> cookie.getName().equals("JSESSIONID")).findFirst();
        if (oldSessionCookie.isPresent()) {
            Cookie cookie = oldSessionCookie.get();
            String username = "email";
            System.err.println(cookie);

            User user = userService.getUserByUsername("email");
            AccountUserDetails userDetails = new AccountUserDetails(user);
            WebAuthenticationDetails authDetails = new WebAuthenticationDetailsSource().buildDetails(request);

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails,
                    null, userDetails.getAuthorities());
            token.setDetails(authDetails);

            Authentication auth = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            System.err.println("authenticated: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
            try {
                authenticationSuccessHandler.onAuthenticationSuccess(request, response, auth);
            } catch (IOException e) {
                throw new IllegalAccessException("wtf");
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }

        // Create a new session and add the security context.
//        request.getSession(true).setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
        return "cur_user_info";
    }
}
