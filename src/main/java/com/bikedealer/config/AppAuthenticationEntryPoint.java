package com.bikedealer.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
@Component
public class AppAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
		     AuthenticationException authException) throws IOException, ServletException {
		response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\" + *************asds***");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage() + "********************");
//		response.sendError(HttpServletResponse.SC_CONFLICT, authException.getLocalizedMessage());
		response.sendError(HttpServletResponse.SC_NOT_FOUND, "Nie ma :(");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("MY APP REALM");
	}
}
