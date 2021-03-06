package com.wisdom.entity.testseries;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wisdom.utility.json.JacksonUtil;

@Entity
@Table(name = "test_series_student_linked_answer")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TestSeriesLinkedAnswer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 26L;

	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "parent_answer_id")
	private long parentAnswerId;
	
	@Column(name = "time_spend", nullable = false)
	private int timeSpend;
	
	@Column(name = "no_of_times_answer_changed", nullable = false)
	private int noOfTimesAnswerChanged;
	
	@Column(name = "answer")
	private String answer;
	
	@Column(name = "question_id", nullable = false)
	private long questionId;
	
	@ManyToOne
	@JoinColumn(name = "parent_answer_id", referencedColumnName = "id", insertable = false, updatable = false)
	private TestSeriesAnswer answerId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getParentAnswerId() {
		return parentAnswerId;
	}
	public void setParentAnswerId(long parentAnswerId) {
		this.parentAnswerId = parentAnswerId;
	}
	public int getTimeSpend() {
		return timeSpend;
	}
	public void setTimeSpend(int timeSpend) {
		this.timeSpend = timeSpend;
	}
	public int getNoOfTimesAnswerChanged() {
		return noOfTimesAnswerChanged;
	}
	public void setNoOfTimesAnswerChanged(int noOfTimesAnswerChanged) {
		this.noOfTimesAnswerChanged = noOfTimesAnswerChanged;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	
	@Override
	public String toString() {
		return JacksonUtil.toString(this);
	}
	
}
