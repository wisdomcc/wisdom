package com.wisdom.bean.question;

import java.util.List;

import com.wisdom.entity.question.LinkedQuestion;
import com.wisdom.entity.question.QuestionParagraph;
import com.wisdom.utility.json.JacksonUtil;

public class QuestionUpdateBean {

	private long id;
	private QuestionParagraph paragraph;
	private String question;
	private QuestionImages images;
	private String type;
	private QuestionOptions options;
	private String hints;
	private int marks;
	private int year;
	private RelatedTo relatedTo;
	private List<LinkedQuestion> linkedQuestions;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public QuestionImages getImages() {
		return images;
	}
	public void setImages(QuestionImages images) {
		this.images = images;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public QuestionOptions getOptions() {
		return options;
	}
	public void setOptions(QuestionOptions options) {
		this.options = options;
	}
	public String getHints() {
		return hints;
	}
	public void setHints(String hints) {
		this.hints = hints;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
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
	public QuestionParagraph getParagraph() {
		return paragraph;
	}
	public void setParagraph(QuestionParagraph paragraph) {
		this.paragraph = paragraph;
	}
	public List<LinkedQuestion> getLinkedQuestions() {
		return linkedQuestions;
	}
	public void setLinkedQuestions(List<LinkedQuestion> linkedQuestions) {
		this.linkedQuestions = linkedQuestions;
	}
	@Override
	public String toString() {
		return JacksonUtil.toString(this);
	}
	
}
