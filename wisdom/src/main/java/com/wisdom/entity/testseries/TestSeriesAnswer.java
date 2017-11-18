package com.wisdom.entity.testseries;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "test_series_student_answer")
public class TestSeriesAnswer {

	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "no_of_times_answer_changed", nullable = false)
	private int noOfTimesAnswerChanged;
	
	@Column(name = "answer")
	private String answer;
	
	@Column(name = "question_id", nullable = false)
	private long questionId;
	
	@Column(name = "test_series_id", nullable = false)
	private long testSeriesId;
	
	@OneToMany(mappedBy = "answerId")
	private List<TestSeriesLinkedAnswer> linkedAnswers;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public long getTestSeriesId() {
		return testSeriesId;
	}
	public void setTestSeriesId(long testSeriesId) {
		this.testSeriesId = testSeriesId;
	}
	
}
