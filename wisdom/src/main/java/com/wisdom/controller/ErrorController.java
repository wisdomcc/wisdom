package com.wisdom.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.bean.ResponseBean;

@RestController
public class ErrorController {
	
	@RequestMapping(path = "/error/badcredentials", method = RequestMethod.GET)
	public ResponseBean badCredentials() {
		return new ResponseBean("Username/Password is incorrect.", "Username/Password is incorrect.", "error");
	}

}
