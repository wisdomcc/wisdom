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
@Table(name = "subject")
public class Subject {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	private long id;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "stream_id")
	@JsonIgnore
	private long streamId;

	@OneToMany
	@JoinColumn(name = "subject_id")
	private Set<Topic> topics;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public long getStreamId() {
		return streamId;
	}

	public void setStreamId(long streamId) {
		this.streamId = streamId;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}
	
}
