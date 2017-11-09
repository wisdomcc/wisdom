package com.wisdom.entity.question;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wisdom.bean.question.QuestionImages;
import com.wisdom.utility.json.JsonStringType;

@Entity
@Table(name = "question_paragraph")
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class) })
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class QuestionParagraph implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "question_id")
	private long questionId;

	@Column(name = "paragraph", columnDefinition = "text")
	private String paragraph;
	
	@Type(type = "json")
	@Column(name = "images", columnDefinition = "json")
	private QuestionImages images;
	
	@OneToOne
	@JoinColumn(name = "question_id", referencedColumnName="id", insertable = false, updatable = false)
	private Question paragraphId;

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

	public QuestionImages getImages() {
		return images;
	}

	public void setImages(QuestionImages images) {
		this.images = images;
	}

	public String getParagraph() {
		return paragraph;
	}

	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}

}
