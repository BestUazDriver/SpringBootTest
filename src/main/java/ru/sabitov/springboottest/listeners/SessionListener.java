package ru.sabitov.springboottest.listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.Optional;
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        Optional<Cookie> oldSessionCookie = Arrays.stream(request.getCookies()).filter(cookie -> cookie.getName().equals("JSESSIONID")).findAny();
        if (oldSessionCookie.isPresent()) {
            System.err.println("oldSessionCookie: " + oldSessionCookie.get().getName() + " : " + oldSessionCookie.get().getValue());
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("email", null, null);
            SecurityContextHolder.getContext().setAuthentication(token);
        } else {
            System.err.println("new user");
        }
        System.err.println("session created");
        HttpSessionListener.super.sessionCreated(se);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSessionListener.super.sessionDestroyed(se);
    }
}
