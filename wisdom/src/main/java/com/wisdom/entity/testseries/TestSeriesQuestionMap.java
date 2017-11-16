package com.wisdom.entity.testseries;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_series_question_map")
public class TestSeriesQuestionMap {

	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "test_series_id", nullable=false)
	private long testSeriesId;
	
	@Column(name = "question_id", nullable=false)
	private long questionId;
	
	@Column(name = "assigned_by", nullable=false)
	private String assignedBy;
	
	@Column(name = "assigned_date", nullable=false)
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
