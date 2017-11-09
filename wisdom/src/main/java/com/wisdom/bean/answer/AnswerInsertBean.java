package com.wisdom.bean.answer;

import com.wisdom.utility.json.JacksonUtil;

public class AnswerInsertBean {

	private long id;
	private long questionId;
	private String answer;
	private AnswerExplanation explanation;
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public AnswerExplanation getExplanation() {
		return explanation;
	}

	public void setExplanation(AnswerExplanation explanation) {
		this.explanation = explanation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

