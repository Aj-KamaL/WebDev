package com.Natwest.netflixzuulapigatewayserver;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class ZuulLoggingFilter extends GenericFilterBean {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		String authheader = httpServletRequest.getHeader("Authorization");
		if(authheader == null || !authheader.startsWith("Bearer")){
			httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
		else
		{
			String jwtToken = authheader.substring(7);
			Claims claims =  Jwts.parser().setSigningKey("secretkey").parseClaimsJws(jwtToken).getBody();
			String username =  Jwts.parser().setSigningKey("secretkey").parseClaimsJws(jwtToken).getBody().getSubject();
			httpServletRequest.setAttribute("username",username);
			chain.doFilter(request,response);
		}

	}
}
