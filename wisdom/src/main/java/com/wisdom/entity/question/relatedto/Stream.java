package com.wisdom.entity.question.relatedto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "stream")
public class Stream {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	private long id;
	
	@Column(name = "stream")
	private String stream;
	
	@Column(name = "exam_id")
	@JsonIgnore
	private long examId;

	@OneToMany
	@JoinColumn(name = "stream_id")
	private Set<Subject> subjects;

	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

}
