package com.wisdom.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.bean.WisdomUser;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public boolean loginUser() {
		return true;
	}
	
	@RequestMapping(path = "/homepage", method = RequestMethod.GET)
	public WisdomUser userHomepage(Principal principal) {
		return (WisdomUser)principal;
	}
	
	@RequestMapping(path = "/registration", method = RequestMethod.GET)
	public boolean registerUser() {
		return true;
	}

}
