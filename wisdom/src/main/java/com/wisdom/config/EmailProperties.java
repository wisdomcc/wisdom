package com.wisdom.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("wisdom.mail")
public class EmailProperties {
	
	private String username;
	private String password;
	private String host;
	private int port;
	private String from;
	private int retryStopTimeInMinutes;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public int getRetryStopTimeInMinutes() {
		return retryStopTimeInMinutes;
	}
	public void setRetryStopTimeInMinutes(int retryStopTimeInMinutes) {
		this.retryStopTimeInMinutes = retryStopTimeInMinutes;
	}

}
