package com.wisdom.security.strategy;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.RedirectStrategy;

import com.wisdom.bean.WisdomUser;

public class CustomAuthenticationSuccessRedirectStrategy implements RedirectStrategy{

	@Override
	public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
		WisdomUser user = (WisdomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		response.getWriter().print(user);
	}

}
