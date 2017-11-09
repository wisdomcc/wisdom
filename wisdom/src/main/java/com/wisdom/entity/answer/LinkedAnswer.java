package com.wisdom.entity.answer;

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

import com.wisdom.bean.answer.AnswerExplanation;
import com.wisdom.entity.question.LinkedQuestion;
import com.wisdom.utility.json.JacksonUtil;
import com.wisdom.utility.json.JsonStringType;

@Entity
@Table(name = "linked_answer")
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class) })
public class LinkedAnswer implements Serializable {

	private static final long serialVersionUID = 10L;

	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "question_id", nullable=false, unique=true)
	private long questionId;

	@Column(name = "answer", nullable=false)
	private String answer;

	@Type(type = "json")
	@Column(name = "explanation", columnDefinition = "json", nullable=false)
	private AnswerExplanation explanation;
	
	@OneToOne
	@JoinColumn(name = "question_id", referencedColumnName="id", insertable = false, updatable = false)
	private LinkedQuestion linkedAnswerId;

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
