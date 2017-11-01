package com.wisdom.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.bean.WisdomUser;

@RestController
public class UserController {
	
	@RequestMapping("/")
	public WisdomUser index(Principal principal) {
		return (WisdomUser)principal;
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public boolean loginUser(Principal principal, HttpSession session) {
		return true;
	}
	
	@RequestMapping(path = "/homepage", method = RequestMethod.GET)
	public WisdomUser userHomepage(Principal principal, HttpSession session) {
		return (WisdomUser)principal;
	}
	
	@RequestMapping(path = "/registration", method = RequestMethod.GET)
	public boolean registerUser() {
		return true;
	}

}
