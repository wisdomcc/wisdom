package com.wisdom.bean.email;

import java.util.Map;

public class EmailTemplate {
	
	private String contentType;
	private Map<String, String> keyValueMap;
	
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public Map<String, String> getKeyValueMap() {
		return keyValueMap;
	}
	public void setKeyValueMap(Map<String, String> keyValueMap) {
		this.keyValueMap = keyValueMap;
	} 

}