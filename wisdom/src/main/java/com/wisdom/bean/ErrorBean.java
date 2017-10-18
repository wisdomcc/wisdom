package com.wisdom.bean;

import com.wisdom.utility.json.JacksonUtil;

public class ErrorBean {

	public ErrorBean(String message, String description) {
		this.message = message;
		this.description = description;
	}
	
	private String message;
	private String description;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return JacksonUtil.toString(this);
	}
}
