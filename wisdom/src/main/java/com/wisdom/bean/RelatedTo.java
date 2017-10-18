package com.wisdom.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wisdom.utility.json.JacksonUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RelatedTo {

	private List<String> exam;
	private List<String> stream;
	private List<String> subject;
	private List<String> topic;
	private List<String> subTopic;
	private List<String> tags;
	
	public RelatedTo() {
		
	}

	public RelatedTo(List<String> exam, List<String> stream, List<String> subject, List<String> topic,
			List<String> subTopic, List<String> language, List<String> project, List<String> tags) {
		this.exam = exam;
		this.stream = stream;
		this.subject = subject;
		this.topic = topic;
		this.subTopic = subTopic;
		this.tags = tags;
	}

	public List<String> getExam() {
		return this.exam;
	}

	public void setExam(List<String> exam) {
		this.exam = exam;
	}

	public List<String> getStream() {
		return this.stream;
	}

	public void setStream(List<String> stream) {
		this.stream = stream;
	}

	public List<String> getSubject() {
		return this.subject;
	}

	public void setSubject(List<String> subject) {
		this.subject = subject;
	}

	public List<String> getTopic() {
		return this.topic;
	}

	public void setTopic(List<String> topic) {
		this.topic = topic;
	}

	public List<String> getSubTopic() {
		return this.subTopic;
	}

	public void setSubTopic(List<String> subTopic) {
		this.subTopic = subTopic;
	}

	public List<String> getTags() {
		return this.tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	/*private List<String> getList(List<String> list) {
		if (list == null) {
			return new ArrayList<String>();
		}
		return list;
	}*/

	@Override
	public String toString() {
		return JacksonUtil.toString(this);
	}
}
