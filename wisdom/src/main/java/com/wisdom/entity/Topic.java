package com.wisdom.entity;

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
@Table(name = "topic")
public class Topic {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	private long id;
	
	@Column(name = "topic")
	private String topic;
	
	@Column(name = "subject_id")
	@JsonIgnore
	private long subjectId;

	@OneToMany
	@JoinColumn(name = "topic_id")
	private Set<SubTopic> subTopics;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public Set<SubTopic> getSubTopics() {
		return subTopics;
	}

	public void setSubTopics(Set<SubTopic> subTopics) {
		this.subTopics = subTopics;
	}
	
}
