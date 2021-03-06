package com.wisdom.entity.question;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wisdom.bean.question.QuestionImages;
import com.wisdom.bean.question.QuestionOptions;
import com.wisdom.entity.answer.LinkedAnswer;
import com.wisdom.utility.json.JacksonUtil;
import com.wisdom.utility.json.JsonStringType;

@Entity
@Table(name = "linked_question")
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class) })
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LinkedQuestion implements Serializable {

	private static final long serialVersionUID = 11L;

	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "parent_question_id")
	private long parentQuestionId;
	
	@Column(name = "question", columnDefinition = "text")
	private String question;

	@Type(type = "json")
	@Column(name = "images", columnDefinition = "json")
	private QuestionImages images;
	
	@Type(type = "json")
	@Column(name = "options", columnDefinition = "json")
	private QuestionOptions options;

	@Column(name = "hints")
	private String hints;
	
	@Column(name = "marks")
	private int marks;
	
	@ManyToOne
	@JoinColumn(name = "parent_question_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Question questionId;
	
	@OneToOne(mappedBy = "linkedAnswerId")
	private LinkedAnswer answer;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getParentQuestionId() {
		return parentQuestionId;
	}

	public void setParentQuestionId(long parentQuestionId) {
		this.parentQuestionId = parentQuestionId;
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
	
	public LinkedAnswer getAnswer() {
		return answer;
	}

	public void setAnswer(LinkedAnswer answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return JacksonUtil.toString(this);
	}

}
