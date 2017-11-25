package com.wisdom.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.bean.email.EmailBean;
import com.wisdom.entity.UserLogin;
import com.wisdom.service.email.EmailService;
import com.wisdom.service.user.UserManagementService;
import com.wisdom.utility.RandomCreationUtil;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserManagementService userManagementService;
	
	@RequestMapping("/send")
	public boolean sendEmail(@RequestParam(value = "name") String name,
			@RequestParam(value = "subject") String subject,
			@RequestParam(value = "emailid") String emailId,
			@RequestParam(value = "message") String message) {
		EmailBean emailBean = new EmailBean();
		emailBean.setBody("Name : " + name + "<br/>" + "Email : " + emailId + "<br/>" + "Subject : " + 
		subject + "<br/>" + "Message : " + message);
		emailBean.setSubject("Email triggered by '" + name + "' using Contact Us submit form.");
		emailBean.setTo(Arrays.asList("navneet.kunal1988@gmail.com", "manishbhanu01@gmail.com",
				"dipaweshpawar@gmail.com","jayvyas92@gmail.com","bkjha90@gmail.com"));
		return emailService.sendEmail(emailBean);
	}
	
	@RequestMapping("/sendpassword")
	public boolean sendEmail(@RequestParam(value = "username") String username) {
		UserLogin userLogin = userManagementService.findUserByUsername(username);
		String password = RandomCreationUtil.createAlphaNumericString(10);
		userLogin.setPassword(passwordEncoder.encode(password));
		EmailBean emailBean = new EmailBean();
		emailBean.setBody("Hi,<br/><br/>Your new password for login : " + password + 
				"<br/><br/><br/>Regards<br/>Wisdom Computer Class Team");
		emailBean.setSubject("New password for Login");
		emailBean.setTo(Arrays.asList(userLogin.getEmailId()));
		if(emailService.sendEmail(emailBean)) {
			userManagementService.updateUser(userLogin);
			return true;
		}
		return false;
	}

}
