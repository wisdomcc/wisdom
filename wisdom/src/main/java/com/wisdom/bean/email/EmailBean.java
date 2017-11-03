package com.wisdom.bean.email;

import java.util.List;

public class EmailBean {

	private String serviceId;
	private List<String> to;
	private String subject;
	private String body;
	private EmailTemplate emailTemplate;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public List<String> getTo() {
		return to;
	}
	public void setTo(List<String> to) {
		this.to = to;
	}
	public EmailTemplate getEmailTemplate() {
		return emailTemplate;
	}
	public void setEmailTemplate(EmailTemplate emailTemplate) {
		this.emailTemplate = emailTemplate;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public boolean verifyCorrectness(){
		if(to == null || to.isEmpty()){
			return false;
		}
		for(String each: to){
			if(!verifyEmailCorrectness(each)){
				return false;
			}
		}
		return true;
	}
	
	private boolean verifyEmailCorrectness(String email){
		return (email != null) && (!email.isEmpty()) && email.length() > 2 
				&& (email.indexOf("@") > 0) && (email.indexOf("@") < email.length() - 1);
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("serviceId: ").append(serviceId).append(" ; ")
			.append("to: ").append(to).append(" ; ")
			.append("subject: ").append(subject).append(" ; ")
			.append("body: ").append(body).append(" ; ")
			.append("emailTemplate: ").append(emailTemplate);
		return sb.toString();
	}
}