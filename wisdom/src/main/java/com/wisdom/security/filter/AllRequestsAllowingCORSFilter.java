package com.wisdom.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllRequestsAllowingCORSFilter extends CORSFilter{

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		setCORSResponseHeaders(request, response);
		if(!request.getMethod().equals("OPTIONS")){
			chain.doFilter(request, response);
		}
	}
	

}