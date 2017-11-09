package com.wisdom.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.bean.ResponseBean;
import com.wisdom.bean.WisdomUser;
import com.wisdom.service.user.UserManagementService;

@RestController
public class UserController {
	
	@Autowired
	private UserManagementService userService;
	
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
	
	@RequestMapping(path = "/registration", method = RequestMethod.POST)
	public ResponseBean registerUser(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "emailid") String emailId) {
		ResponseBean response = new ResponseBean();
		userService.addUser(username, emailId, password);
		response.setMessage("Successfully registered. Login using username.");
		response.setType("success");
		return response;
	}
	
	@RequestMapping(path = "/isusernamepresent", method = RequestMethod.POST)
	public ResponseBean isUsernameExisting(@RequestParam(value = "username") String username) {
		ResponseBean response = new ResponseBean();
		boolean isUsernameExisting = userService.isUsernameExisting(username);
		if(isUsernameExisting) {
			response.setMessage("Username has already been registered.");
			response.setType("error");
		}
		return response;
	}
	
	@RequestMapping(path = "/isemailpresent", method = RequestMethod.POST)
	public ResponseBean isEmailExisting(@RequestParam(value = "emailid") String emailId) {
		ResponseBean response = new ResponseBean();
		boolean isEmailExisting = userService.isEmailExisting(emailId);
		if(isEmailExisting) {
			response.setMessage("EmailId has already been registered.");
			response.setType("error");
		}
		return response;
	}

}
