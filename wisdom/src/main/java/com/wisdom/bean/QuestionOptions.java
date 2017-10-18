package com.wisdom.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class QuestionOptions {

	private String type;
	private List<String> option;
	private List<String> imagePath;

	public QuestionOptions() {

	}

	public QuestionOptions(String type, List<String> option, List<String> imagePath) {
		this.type = type;
		this.option = option;
		this.imagePath = imagePath;
	}

	public List<String> getOption() {
		return option;
	}

	public void setOption(List<String> option) {
		this.option = option;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getImagePath() {
		return imagePath;
	}

	public void setImagePath(List<String> imagePath) {
		this.imagePath = imagePath;
	}

}
