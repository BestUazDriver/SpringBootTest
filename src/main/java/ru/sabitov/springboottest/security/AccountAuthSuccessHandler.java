package ru.sabitov.springboottest.security;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ru.sabitov.springboottest.models.User;
import ru.sabitov.springboottest.security.details.AccountUserDetails;

@Component
public class AccountAuthSuccessHandler implements AuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        request.getSession().setMaxInactiveInterval(111111111);
        System.err.println("on Auth Succ");
        response.sendRedirect("/test");
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
		AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
        request.getSession().setMaxInactiveInterval(111111111);
        System.err.println("on Auth Succ2");
        response.sendRedirect("/test");
	}

	public String getRedirectUrl(HttpServletRequest request) {
		String result = null;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
			Object principal = authentication.getPrincipal();
			AccountUserDetails userDetails = null;
			String role = null;
			if (principal instanceof AccountUserDetails) {
				userDetails = (AccountUserDetails) principal;
				role = String.valueOf(userDetails.getUser().getRole());
			}
			if (userDetails == null)
				return result;
			if (authorities != null && !authorities.isEmpty()) {
				result = "/user_info";
			}
		}
		return result;
	}

}
