package com.wisdom.bean.answer;

import java.util.List;

public class AnswerExplanation {

	private String description;
	private List<String> answerImagePath;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getAnswerImagePath() {
		return answerImagePath;
	}

	public void setAnswerImagePath(List<String> answerImagePath) {
		this.answerImagePath = answerImagePath;
	}
	
}
