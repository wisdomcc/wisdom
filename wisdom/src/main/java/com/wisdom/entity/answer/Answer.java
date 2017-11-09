package com.wisdom.entity.answer;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.wisdom.bean.answer.AnswerExplanation;
import com.wisdom.utility.json.JacksonUtil;
import com.wisdom.utility.json.JsonStringType;

@Entity
@Table(name = "answer")
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class) })
public class Answer implements Serializable {

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
	
	@Column(name = "inserted_by")
	private String insertedBy;
	
	@Column(name = "inserted_date")
	private Date insertedDate;
	
	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_date")
	private Date updatedDate;

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
	
	public String getInsertedBy() {
		return insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}

	public Date getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return JacksonUtil.toString(this);
	}

}
