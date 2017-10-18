package com.wisdom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wisdom.bean.QuestionImages;
import com.wisdom.bean.QuestionOptions;
import com.wisdom.bean.RelatedTo;
import com.wisdom.utility.json.JacksonUtil;
import com.wisdom.utility.json.JsonStringType;

@Entity
@Table(name = "question")
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class) })
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Question implements Serializable {

	private static final long serialVersionUID = 10L;

	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "question", columnDefinition = "text")
	private String question;

	@Type(type = "json")
	@Column(name = "images", columnDefinition = "json")
	private QuestionImages images;

	@Column(name = "type")
	private String type;

	@Type(type = "json")
	@Column(name = "options", columnDefinition = "json")
	private QuestionOptions options;

	@Column(name = "hints")
	private String hints;
	
	@Column(name = "marks")
	private int marks;

	@Column(name = "year")
	private int year;

	@Type(type = "json")
	@Column(name = "related_to", columnDefinition = "json")
	private RelatedTo relatedTo;
	
	@OneToOne
	@JoinColumn(name = "id")
	@JsonIgnore
	private Answer answerId;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
	
	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public QuestionImages getImages() {
		return images;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setImages(QuestionImages images) {
		this.images = images;
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
	
	public Answer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Answer answerId) {
		this.answerId = answerId;
	}
	
	@Override
	public String toString() {
		return JacksonUtil.toString(this);
	}

}
