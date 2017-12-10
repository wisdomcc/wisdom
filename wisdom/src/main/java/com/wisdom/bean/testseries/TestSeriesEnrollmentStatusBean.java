package com.wisdom.bean.testseries;

import java.sql.Date;

public class TestSeriesEnrollmentStatusBean {

	private long id;
	private Date activateDate;
	private Date deactivateDate;
	private String type;
	private int duration;
	private String exam;
	private String stream;
	private String subject;
	private String topic;
	private int noOfQuestion;
	private String createdBy;
	private Date createdDate;
	private String testSeriesStatus;
	private int remainingExamDuration;
	private long enrollmentId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getActivateDate() {
		return activateDate;
	}

	public void setActivateDate(Date activateDate) {
		this.activateDate = activateDate;
	}

	public Date getDeactivateDate() {
		return deactivateDate;
	}

	public void setDeactivateDate(Date deactivateDate) {
		this.deactivateDate = deactivateDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getExam() {
		return exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getNoOfQuestion() {
		return noOfQuestion;
	}

	public void setNoOfQuestion(int noOfQuestion) {
		this.noOfQuestion = noOfQuestion;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getTestSeriesStatus() {
		return testSeriesStatus;
	}

	public void setTestSeriesStatus(String testSeriesStatus) {
		this.testSeriesStatus = testSeriesStatus;
	}

	public long getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public int getRemainingExamDuration() {
		return remainingExamDuration;
	}

	public void setRemainingExamDuration(int remainingExamDuration) {
		this.remainingExamDuration = remainingExamDuration;
	}
	
}
