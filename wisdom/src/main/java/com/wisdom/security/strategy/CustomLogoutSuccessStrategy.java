package com.wisdom.security.strategy;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.RedirectStrategy;

public class CustomLogoutSuccessStrategy implements RedirectStrategy{

	@Override
	public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
		response.getWriter().print("logout");
	}

}
