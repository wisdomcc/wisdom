package com.wisdom.utility;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import com.wisdom.bean.QuestionFetchBean;
import com.wisdom.bean.QuestionInsertBean;
import com.wisdom.bean.QuestionUpdateBean;
import com.wisdom.constant.QueryConstant;
import com.wisdom.entity.Question;

public class WisdomUtility {

	public static Question buildQuestion(QuestionInsertBean questionInsertBean, String username) {
		Question question = new Question();
		question.setId(questionInsertBean.getId());
		question.setHints(questionInsertBean.getHints());
		question.setOptions(questionInsertBean.getOptions());
		question.setQuestion(questionInsertBean.getQuestion());
		question.setImages(questionInsertBean.getImages());
		question.setType(questionInsertBean.getType());
		question.setYear(questionInsertBean.getYear());
		question.setMarks(questionInsertBean.getMarks());
		question.setRelatedTo(questionInsertBean.getRelatedTo());
		question.setInsertedBy(username);
		question.setInsertedDate(new Date(System.currentTimeMillis()));
		return question;
	}
	
	public static Question buildQuestion(QuestionUpdateBean questionUpdateBean, String username) {
		Question question = new Question();
		question.setId(questionUpdateBean.getId());
		question.setHints(questionUpdateBean.getHints());
		question.setOptions(questionUpdateBean.getOptions());
		question.setQuestion(questionUpdateBean.getQuestion());
		question.setImages(questionUpdateBean.getImages());
		question.setType(questionUpdateBean.getType());
		question.setYear(questionUpdateBean.getYear());
		question.setMarks(questionUpdateBean.getMarks());
		question.setRelatedTo(questionUpdateBean.getRelatedTo());
		question.setUpdatedBy(username);
		question.setUpdatedDate(new Date(System.currentTimeMillis()));
		return question;
	}
	
	public static Map<Integer, Object> buildQuery(QuestionFetchBean questionFetchBean) {
		Map<Integer, Object> queryMap = new HashMap<Integer, Object>();
		int index = 0;
		String query = QueryConstant.SEARCH_QUESTION_BY_RELATED_TO;
		queryMap.put(++index, questionFetchBean.getRelatedTo().toString());
		if (questionFetchBean.getMarks() != 0) {
			queryMap.put(++index, questionFetchBean.getMarks());
			query = query + QueryConstant.BY_MARKS;
		}
		if (questionFetchBean.getType() != null) {
			queryMap.put(++index, questionFetchBean.getType());
			query = query + QueryConstant.BY_TYPE;
		}
		if (questionFetchBean.getToYear() == 0 && questionFetchBean.getFromYear() != 0) {
			queryMap.put(++index, questionFetchBean.getFromYear());
			query = query + QueryConstant.BY_YEAR;
		}
		if (questionFetchBean.getToYear() != 0 && questionFetchBean.getFromYear() != 0) {
			queryMap.put(++index, questionFetchBean.getFromYear());
			queryMap.put(++index, questionFetchBean.getToYear());
			query = query + QueryConstant.BY_YEAR_BETWEEN;
		}
		queryMap.put(++index, query);
		return queryMap;
	}
	
}
