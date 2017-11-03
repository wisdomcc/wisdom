package com.wisdom.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.bean.email.EmailBean;
import com.wisdom.service.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/sendemail")
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

}
