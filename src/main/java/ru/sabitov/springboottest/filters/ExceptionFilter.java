package ru.sabitov.springboottest.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.sabitov.springboottest.repository.UserRepository;

import java.io.IOException;

@Component
public class ExceptionFilter extends GenericFilterBean {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.err.println(userRepository.getAllUsers());
    }
}
