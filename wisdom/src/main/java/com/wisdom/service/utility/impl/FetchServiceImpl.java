package com.wisdom.service.utility.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.bean.question.QuestionFetchBean;
import com.wisdom.dao.NativeQueryQuestionDao;
import com.wisdom.dao.question.QuestionDao;
import com.wisdom.dao.testseries.TestSeriesDao;
import com.wisdom.dao.testseries.TestSeriesEnrollmentDao;
import com.wisdom.dao.testseries.TestSeriesQuestionMapDao;
import com.wisdom.entity.question.Question;
import com.wisdom.entity.testseries.TestSeries;
import com.wisdom.entity.testseries.TestSeriesEnrollment;
import com.wisdom.entity.testseries.TestSeriesQuestionMap;
import com.wisdom.exception.FetchException;
import com.wisdom.service.utility.FetchService;

public class FetchServiceImpl implements FetchService {
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private TestSeriesQuestionMapDao testSeriesQuestionMapDao;
	
	@Autowired
	private TestSeriesDao testSeriesDao;
	
	@Autowired
	private TestSeriesEnrollmentDao testSeriesEnrollmentDao;
	
	@Autowired
	private NativeQueryQuestionDao nativeQueryQuestionDao;

	@Override
	public List<Question> getQuestions(QuestionFetchBean questionRequestBean) throws FetchException {
		return nativeQueryQuestionDao.findByQuestionFetchBean(questionRequestBean);
	}

	@Override
	public Question getQuestion(int id) throws FetchException {
		return questionDao.findById(id);
	}

	@Override
	public List<Question> getQuestions(long testSeriesId) throws FetchException {
		List<Question> questions = new ArrayList<Question>();
		for(TestSeriesQuestionMap testSeriesQuestionMap : testSeriesQuestionMapDao.findByTestSeriesId(testSeriesId)) {
			questions.add(questionDao.findById(testSeriesQuestionMap.getQuestionId()));
		}
		return questions;
	}

	@Override
	public List<TestSeries> getTestSeries(String username) throws FetchException {
		List<TestSeries> testSeries = new ArrayList<TestSeries>();
		for(TestSeriesEnrollment testSeriesEnrollment : testSeriesEnrollmentDao.findByUsername(username)) {
			testSeries.add(testSeriesDao.findById(testSeriesEnrollment.getTestSeriesId()));
		}
		return testSeries;
	}

}
