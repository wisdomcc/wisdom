package com.wisdom.bean.testseries;

import java.util.List;

import com.wisdom.entity.testseries.TestSeriesLinkedAnswer;

public class TestSeriesAnswerBean {

	private long id;
	private String username;
	private int noOfTimesAnswerChanged;
	private String answer;
	private long questionId;
	private long testSeriesId;
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
	public List<TestSeriesLinkedAnswer> getLinkedAnswers() {
		return linkedAnswers;
	}
	public void setLinkedAnswers(List<TestSeriesLinkedAnswer> linkedAnswers) {
		this.linkedAnswers = linkedAnswers;
	}
	
}
