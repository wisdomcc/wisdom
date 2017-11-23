package com.wisdom.bean;

import com.wisdom.utility.json.JacksonUtil;

public class ResponseBean {

	public ResponseBean(String message, String description, String type) {
		this.message = message;
		this.description = description;
		this.type = type;
	}
	public ResponseBean(){}
	
	private String message;
	private String description;
	private String type;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return JacksonUtil.toString(this);
	}
	
}
