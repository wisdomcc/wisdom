package com.wisdom.utility;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import com.wisdom.bean.answer.AnswerInsertBean;
import com.wisdom.bean.answer.AnswerUpdateBean;
import com.wisdom.bean.question.QuestionFetchBean;
import com.wisdom.bean.question.QuestionInsertBean;
import com.wisdom.bean.question.QuestionUpdateBean;
import com.wisdom.bean.testseries.TestSeriesInsertBean;
import com.wisdom.bean.testseries.TestSeriesUpdateBean;
import com.wisdom.constant.QueryConstant;
import com.wisdom.entity.answer.Answer;
import com.wisdom.entity.question.Question;
import com.wisdom.entity.testseries.TestSeries;

public class WisdomUtility {

	public static Question buildQuestion(QuestionInsertBean questionInsertBean, String username) {
		Question question = new Question();
		question.setId(questionInsertBean.getId());
		question.setHints(questionInsertBean.getHints());
		question.setOptions(questionInsertBean.getOptions());
		question.setQuestion(questionInsertBean.getQuestion());
		//question.setParagraph(questionInsertBean.getParagraph());
		//question.setLinkedQuestions(questionInsertBean.getLinkedQuestions());
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
		//question.setParagraph(questionUpdateBean.getParagraph());
		//question.setLinkedQuestions(questionUpdateBean.getLinkedQuestions());
		question.setImages(questionUpdateBean.getImages());
		question.setType(questionUpdateBean.getType());
		question.setYear(questionUpdateBean.getYear());
		question.setMarks(questionUpdateBean.getMarks());
		question.setRelatedTo(questionUpdateBean.getRelatedTo());
		question.setUpdatedBy(username);
		question.setUpdatedDate(new Date(System.currentTimeMillis()));
		return question;
	}
	
	public static Answer buildQuestion(AnswerUpdateBean answerUpdateBean, String username) {
		Answer answer = new Answer();
		answer.setId(answerUpdateBean.getId());
		answer.setQuestionId(answerUpdateBean.getQuestionId());
		answer.setAnswer(answerUpdateBean.getAnswer());
		answer.setExplanation(answerUpdateBean.getExplanation());
		answer.setUpdatedBy(username);
		answer.setUpdatedDate(new Date(System.currentTimeMillis()));
		return answer;
	}
	
	public static Answer buildQuestion(AnswerInsertBean answerInsertBean, String username) {
		Answer answer = new Answer();
		answer.setId(answerInsertBean.getId());
		answer.setQuestionId(answerInsertBean.getQuestionId());
		answer.setAnswer(answerInsertBean.getAnswer());
		answer.setExplanation(answerInsertBean.getExplanation());
		answer.setInsertedBy(username);
		answer.setInsertedDate(new Date(System.currentTimeMillis()));
		return answer;
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

	public static TestSeries buildQuestion(TestSeriesUpdateBean testSeriesUpdateBean, String username) {
		TestSeries testSeries = new TestSeries();
		testSeries.setId(testSeriesUpdateBean.getId());
		testSeries.setActivateDate(testSeriesUpdateBean.getActivateDate());
		testSeries.setDeactivateDate(testSeriesUpdateBean.getDeactivateDate());
		testSeries.setDuration(testSeriesUpdateBean.getDuration());
		testSeries.setNoOfQuestion(testSeriesUpdateBean.getNoOfQuestion());
		testSeries.setType(testSeriesUpdateBean.getType());
		testSeries.setExam(testSeriesUpdateBean.getExam());
		testSeries.setStream(testSeriesUpdateBean.getStream());
		testSeries.setSubject(testSeriesUpdateBean.getSubject());
		testSeries.setTopic(testSeriesUpdateBean.getTopic());
		testSeries.setCreatedBy(username);
		testSeries.setCreatedDate(new Date(System.currentTimeMillis()));
		return testSeries;
	}
	
	public static TestSeries buildQuestion(TestSeriesInsertBean testSeriesInsertBean, String username) {
		TestSeries testSeries = new TestSeries();
		testSeries.setId(testSeriesInsertBean.getId());
		testSeries.setActivateDate(testSeriesInsertBean.getActivateDate());
		testSeries.setDeactivateDate(testSeriesInsertBean.getDeactivateDate());
		testSeries.setDuration(testSeriesInsertBean.getDuration());
		testSeries.setNoOfQuestion(testSeriesInsertBean.getNoOfQuestion());
		testSeries.setType(testSeriesInsertBean.getType());
		testSeries.setExam(testSeriesInsertBean.getExam());
		testSeries.setStream(testSeriesInsertBean.getStream());
		testSeries.setSubject(testSeriesInsertBean.getSubject());
		testSeries.setTopic(testSeriesInsertBean.getTopic());
		testSeries.setCreatedBy(username);
		testSeries.setCreatedDate(new Date(System.currentTimeMillis()));
		return testSeries;
	}
	
}
