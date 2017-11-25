package com.wisdom.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.bean.ResponseBean;
import com.wisdom.service.user.UserManagementService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserManagementService userService;
	
	@RequestMapping(path = "/changepassword", method = RequestMethod.POST)
	public ResponseBean changePassword(Principal principal, @RequestParam(value = "oldpassword") String oldPassword,
			@RequestParam(value = "newpassword") String newPassword) {
		ResponseBean response = new ResponseBean();
		if(userService.changePassword(principal.getName(), oldPassword, newPassword)) {
			response.setMessage("Password Successfully changed.");
			response.setType("status");
		} else {
			response.setMessage("Password change failed. Old password is wrong.");
			response.setType("error");
		}
		return response;
	}
	
	@RequestMapping(path = "/registration", method = RequestMethod.POST)
	public ResponseBean registerUser(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "emailid") String emailId) {
		ResponseBean response = new ResponseBean();
		userService.addUser(username, emailId, password);
		response.setMessage("Successfully registered. Login using username.");
		response.setType("status");
		return response;
	}
	
	@RequestMapping(path = "/ispresent", method = RequestMethod.POST)
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
