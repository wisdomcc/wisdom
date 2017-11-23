package com.wisdom.service.utility;

import java.util.List;

import com.wisdom.bean.question.QuestionFetchBean;
import com.wisdom.entity.question.Question;
import com.wisdom.entity.testseries.TestSeries;
import com.wisdom.exception.FetchException;

public interface FetchService {

	public List<Question> getQuestions(QuestionFetchBean questionRequestBean) throws FetchException;
	public Question getQuestion(int id) throws FetchException;
	public List<Question> getQuestions(long testSeriesId) throws FetchException;
	public List<TestSeries> getTestSeries(String username) throws FetchException;
	
}
