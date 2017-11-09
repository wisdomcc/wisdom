package com.wisdom.entity.question;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wisdom.bean.question.QuestionImages;
import com.wisdom.bean.question.QuestionOptions;
import com.wisdom.bean.question.RelatedTo;
import com.wisdom.entity.answer.Answer;
import com.wisdom.utility.json.JacksonUtil;
import com.wisdom.utility.json.JsonStringType;

@Entity
@Table(name = "question")
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class) })
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 21L;

	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "question", columnDefinition = "text", nullable=false)
	private String question;

	@Type(type = "json")
	@Column(name = "images", columnDefinition = "json")
	private QuestionImages images;

	@Column(name = "type", nullable=false)
	private String type;

	@Type(type = "json")
	@Column(name = "options", columnDefinition = "json")
	private QuestionOptions options;

	@Column(name = "hints")
	private String hints;
	
	@Column(name = "marks", nullable=false)
	private int marks;

	@Column(name = "year", nullable=false)
	private int year;

	@Type(type = "json")
	@Column(name = "related_to", columnDefinition = "json")
	private RelatedTo relatedTo;
	
	@Column(name = "inserted_by")
	private String insertedBy;
	
	@Column(name = "inserted_date")
	private Date insertedDate;
	
	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_date")
	private Date updatedDate;
	
	@OneToMany(mappedBy = "questionId")
	private List<LinkedQuestion> linkedQuestions;
	
	@OneToOne(mappedBy = "paragraphId")
	private QuestionParagraph paragraph;
	
	@OneToOne
	@JoinColumn(name = "id", referencedColumnName="question_id")
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
	
	public Answer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Answer answerId) {
		this.answerId = answerId;
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
