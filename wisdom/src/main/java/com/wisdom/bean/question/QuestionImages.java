package com.wisdom.bean.question;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class QuestionImages {

	private List<String> paths;

	public QuestionImages() {

	}

	public QuestionImages(List<String> paths) {
		this.paths = paths;
	}

	public List<String> getPaths() {
		return paths;
	}

	public void setPaths(List<String> paths) {
		this.paths = paths;
	}

}
