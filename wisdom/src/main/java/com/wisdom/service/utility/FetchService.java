package com.wisdom.service.utility;

import java.util.List;

import com.wisdom.bean.question.QuestionFetchBean;
import com.wisdom.bean.testseries.TestSeriesEnrollmentStatusBean;
import com.wisdom.entity.question.Question;
import com.wisdom.entity.testseries.TestSeriesAnswer;
import com.wisdom.entity.testseries.TestSeriesQuestionMap;
import com.wisdom.exception.FetchException;

public interface FetchService {

	public List<Question> getQuestions(QuestionFetchBean questionRequestBean) throws FetchException;
	public Question getQuestion(int id) throws FetchException;
	public List<Question> getQuestions(long testSeriesId) throws FetchException;
	public List<TestSeriesEnrollmentStatusBean> getTestSeriesEnrollmentStatus(String username) throws FetchException;
	public List<TestSeriesAnswer> fetch(long testSeriesId, String username) throws FetchException;
	public TestSeriesQuestionMap getTestSeriesQuestionMap(long testSeriesId, long questionId) throws FetchException;
	
}
