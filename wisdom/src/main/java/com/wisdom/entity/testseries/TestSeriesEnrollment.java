package com.wisdom.entity.testseries;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "test_series_student_enrollment",
		uniqueConstraints={
	    @UniqueConstraint(columnNames = {"test_series_id", "username"})
	})
public class TestSeriesEnrollment {

	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "test_series_id", nullable=false)
	private long testSeriesId;
	
	@Column(name = "username", nullable=false)
	private String username;
	
	@Column(name = "scheme", nullable=false)
	private String scheme;
	
	@Column(name = "enrollment_date", nullable=false)
	private Date enrollmentDate;
	
	@Column(name = "test_series_status", nullable=false)
	private String testSeriesStatus;
	
	@Column(name = "remaining_exam_duration", nullable=false)
	private int remainingExamDuration;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTestSeriesId() {
		return testSeriesId;
	}
	public void setTestSeriesId(long testSeriesId) {
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
	public String getTestSeriesStatus() {
		return testSeriesStatus;
	}
	public void setTestSeriesStatus(String testSeriesStatus) {
		this.testSeriesStatus = testSeriesStatus;
	}
	public int getRemainingExamDuration() {
		return remainingExamDuration;
	}
	public void setRemainingExamDuration(int remainingExamDuration) {
		this.remainingExamDuration = remainingExamDuration;
	}
}
