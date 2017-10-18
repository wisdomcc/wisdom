package com.wisdom.bean;

import com.wisdom.utility.json.JacksonUtil;

public class QuestionFetchBean {

	private RelatedTo relatedTo;
	private String type;
	private int marks;
	private int fromYear;
	private int toYear;

	public int getFromYear() {
		return fromYear;
	}

	public void setFromYear(int fromYear) {
		this.fromYear = fromYear;
	}

	public int getToYear() {
		return toYear;
	}

	public void setToYear(int toYear) {
		this.toYear = toYear;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public RelatedTo getRelatedTo() {
		return relatedTo;
	}

	public void setRelatedTo(RelatedTo relatedTo) {
		this.relatedTo = relatedTo;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return JacksonUtil.toString(this);
	}

}
