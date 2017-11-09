package com.wisdom.service.email.impl;

import java.util.Date;
import java.util.Map;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.bean.email.EmailBean;
import com.wisdom.config.EmailProperties;
import com.wisdom.service.email.EmailService;

public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private EmailProperties emailProps;

	@Autowired
	private Session session;

	@Autowired
	private Transport transport;

	private static Logger log = LogManager.getLogger(EmailServiceImpl.class);

	@Override
	public boolean sendEmail(EmailBean email) {
		log.debug("sending email start : id{}");
		boolean sentStatus = true;
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(emailProps.getFrom()));
			msg.setRecipients(Message.RecipientType.TO, getToAddresses(email));
			msg.setSubject(email.getSubject());
				setSimpleEmailMessage(email, msg);
			msg.setSentDate(new Date(System.currentTimeMillis()));
			if (!transport.isConnected()) {
				transport.connect(emailProps.getHost(), emailProps.getUsername(), emailProps.getPassword());
			}
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
		} catch (Exception ex) {
			sentStatus = false;
			log.debug("sending email failed : id{} : reason{}" + ex);
		}
		log.debug("sending email end : id{}");
		return sentStatus;
	}
	
	private void setSimpleEmailMessage(EmailBean email, MimeMessage msg) throws Exception {
		if (email.getEmailTemplate() == null) {
			msg.setContent(email.getBody(), "text/html; charset=utf-8");
		} else {
			for (Map.Entry<String, String> keyValue : email.getEmailTemplate().getKeyValueMap().entrySet()) {
				email.setBody(email.getBody().replace(keyValue.getKey(), keyValue.getValue()));
			}
			msg.setContent(email.getBody(), email.getEmailTemplate().getContentType());
		}
	}
	
	private Address[] getToAddresses(EmailBean email) throws AddressException {
		Address addresses[] = new Address[email.getTo().size()];
		int index = 0;
		for (String toValue : email.getTo()) {
			addresses[index] = new InternetAddress(toValue);
			++index;
		}
		return addresses;
	}

}
