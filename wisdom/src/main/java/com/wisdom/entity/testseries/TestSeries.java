package com.wisdom.entity.testseries;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_series")
public class TestSeries {

	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "activate_date", nullable=false)
	private Date activateDate;
	
	@Column(name = "deactivate_date", nullable=false)
	private Date deactivateDate;
	
	@Column(name = "type", nullable=false)
	private String type;
	
	@Column(name = "duration", nullable=false)
	private int duration;
	
	@Column(name = "exam", nullable=false)
	private String exam;
	
	@Column(name = "stream", nullable=false)
	private String stream;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "topic")
	private String topic;
	
	@Column(name = "no_of_question", nullable=false)
	private int noOfQuestion;
	
	@Column(name = "created_by", nullable=false)
	private String createdBy;
	
	@Column(name = "created_date", nullable=false)
	private Date created_date;

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

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	
}
