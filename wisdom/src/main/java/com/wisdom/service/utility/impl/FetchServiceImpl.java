package com.wisdom.service.utility.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.bean.question.QuestionFetchBean;
import com.wisdom.bean.testseries.TestSeriesEnrollmentStatusBean;
import com.wisdom.dao.NativeQueryQuestionDao;
import com.wisdom.dao.question.QuestionDao;
import com.wisdom.dao.testseries.TestSeriesAnswerDao;
import com.wisdom.dao.testseries.TestSeriesDao;
import com.wisdom.dao.testseries.TestSeriesEnrollmentDao;
import com.wisdom.dao.testseries.TestSeriesQuestionMapDao;
import com.wisdom.entity.question.Question;
import com.wisdom.entity.testseries.TestSeriesAnswer;
import com.wisdom.entity.testseries.TestSeriesEnrollment;
import com.wisdom.entity.testseries.TestSeriesQuestionMap;
import com.wisdom.exception.FetchException;
import com.wisdom.service.utility.FetchService;
import com.wisdom.utility.converters.testseries.TestSeriesConverters;

public class FetchServiceImpl implements FetchService {

	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private TestSeriesAnswerDao testSeriesAnswerDao;

	@Autowired
	private TestSeriesQuestionMapDao testSeriesQuestionMapDao;

	@Autowired
	private TestSeriesDao testSeriesDao;

	@Autowired
	private TestSeriesEnrollmentDao testSeriesEnrollmentDao;

	@Autowired
	private NativeQueryQuestionDao nativeQueryQuestionDao;

	@Autowired
	private TestSeriesConverters testSeriesConverters;

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
		for (TestSeriesQuestionMap testSeriesQuestionMap : testSeriesQuestionMapDao.findByTestSeriesId(testSeriesId)) {
			questions.add(questionDao.findById(testSeriesQuestionMap.getQuestionId()));
		}
		return questions;
	}

	@Override
	public List<TestSeriesEnrollmentStatusBean> getTestSeriesEnrollmentStatus(String username) throws FetchException {
		List<TestSeriesEnrollmentStatusBean> testSeriesEnrollmentStatus = new ArrayList<TestSeriesEnrollmentStatusBean>();
		for (TestSeriesEnrollment testSeriesEnrollment : testSeriesEnrollmentDao.findByUsername(username)) {
			testSeriesEnrollmentStatus.add(testSeriesConverters.convertTestSeriesToEnrollmentStatusBean(
					testSeriesDao.findById(testSeriesEnrollment.getTestSeriesId()),
					testSeriesEnrollment.getTestSeriesStatus(), testSeriesEnrollment.getRemainingExamDuration(),
					testSeriesEnrollment.getId()));
		}
		return testSeriesEnrollmentStatus;
	}

	@Override
	public List<TestSeriesAnswer> fetch(long testSeriesId, String username) throws FetchException {
		return testSeriesAnswerDao.findByTestSeriesIdAndUsername(testSeriesId, username);
	}

}
