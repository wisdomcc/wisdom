package com.wisdom.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("aws")
public class AwsProperties {

	private String accessKey;
	private String secretKey;
	private String region;
	
	public String getAccessKey() {
		return accessKey;
	}
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
}
