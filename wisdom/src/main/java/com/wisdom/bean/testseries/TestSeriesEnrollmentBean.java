package com.wisdom.bean.testseries;

import java.sql.Date;

public class TestSeriesEnrollmentBean {

	private long id;
	private String testSeriesId;
	private String username;
	private String scheme;
	private Date enrollmentDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTestSeriesId() {
		return testSeriesId;
	}
	public void setTestSeriesId(String testSeriesId) {
		this.testSeriesId = testSeriesId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
}
