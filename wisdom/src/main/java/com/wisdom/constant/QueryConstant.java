package com.wisdom.constant;

public interface QueryConstant {

	public String SEARCH_QUESTION_BY_RELATED_TO = "select * from question where json_contains(related_to,?)";
	public String BY_MARKS = " and marks=?";
	public String BY_TYPE = " and type=?";
	public String BY_YEAR = " and year=?";
	public String BY_YEAR_BETWEEN = " and year>=? and year<=?";
	
}
