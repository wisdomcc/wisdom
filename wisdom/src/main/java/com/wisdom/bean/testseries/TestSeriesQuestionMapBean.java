package com.wisdom.bean.testseries;

import java.sql.Date;

public class TestSeriesQuestionMapBean {

	private long id;
	private long testSeriesId;
	private long questionId;
	private String assignedBy;
	private Date assignedDate;

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

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

}
