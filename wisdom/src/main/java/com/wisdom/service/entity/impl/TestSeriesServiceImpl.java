package com.wisdom.service.entity.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.bean.testseries.TestSeriesAnswerBean;
import com.wisdom.bean.testseries.TestSeriesEnrollmentBean;
import com.wisdom.bean.testseries.TestSeriesEnrollmentStatusBean;
import com.wisdom.bean.testseries.TestSeriesInsertBean;
import com.wisdom.bean.testseries.TestSeriesQuestionMapBean;
import com.wisdom.bean.testseries.TestSeriesUpdateBean;
import com.wisdom.entity.question.Question;
import com.wisdom.entity.testseries.TestSeries;
import com.wisdom.entity.testseries.TestSeriesAnswer;
import com.wisdom.entity.testseries.TestSeriesEnrollment;
import com.wisdom.entity.testseries.TestSeriesLinkedAnswer;
import com.wisdom.entity.testseries.TestSeriesQuestionMap;
import com.wisdom.exception.FetchException;
import com.wisdom.exception.InsertException;
import com.wisdom.exception.UpdateException;
import com.wisdom.service.entity.TestSeriesService;
import com.wisdom.service.utility.FetchService;
import com.wisdom.service.utility.InsertService;
import com.wisdom.service.utility.UpdateService;
import com.wisdom.utility.converters.testseries.TestSeriesConverters;

public class TestSeriesServiceImpl implements TestSeriesService {

	@Autowired
	private InsertService insertService;
	
	@Autowired
	private UpdateService updateService;
	
	@Autowired
	private FetchService fetchService;
	
	@Autowired
	private TestSeriesConverters testSeriesConverters;
	
	@Override
	public boolean updateTestSeries(List<TestSeriesUpdateBean> testSeriesUpdateBeans, String username)
			throws UpdateException {
		for(TestSeriesUpdateBean testSeriesUpdateBean : testSeriesUpdateBeans) {
			TestSeries testSeries = testSeriesConverters.convertBeanToEntity(testSeriesUpdateBean, username);
			updateService.update(testSeries);
		}
		return true;
	}

	@Override
	public boolean insertTestSeries(List<TestSeriesInsertBean> testSeriesInsertBeans, String username)
			throws UpdateException {
		for(TestSeriesInsertBean testSeriesInsertBean : testSeriesInsertBeans) {
			TestSeries testSeries = testSeriesConverters.convertBeanToEntity(testSeriesInsertBean, username);
			insertService.insert(testSeries);
		}
		return true;
	}

	@Override
	public boolean insertTestSeriesQuestionMap(List<TestSeriesQuestionMapBean> testSeriesQuestionMapBeans,
			String username) throws InsertException {
		for(TestSeriesQuestionMapBean testSeriesQuestionMapBean : testSeriesQuestionMapBeans) {
			TestSeriesQuestionMap testSeriesQuestionMap = testSeriesConverters.convertBeanToEntity(testSeriesQuestionMapBean, username);
			insertService.insert(testSeriesQuestionMap);
		}
		return true;
	}
	
	@Override
	public boolean enrollTestSeries(List<TestSeriesEnrollmentBean> testSeriesEnrollmentBeans,
			String username) throws InsertException {
		for(TestSeriesEnrollmentBean testSeriesEnrollmentBean : testSeriesEnrollmentBeans) {
			TestSeriesEnrollment testSeriesEnrollment = testSeriesConverters.convertBeanToEntity(testSeriesEnrollmentBean, username);
			insertService.insert(testSeriesEnrollment);
		}
		return true;
	}
	
	@Override
	public boolean submitTestSeries(List<TestSeriesAnswerBean> testSeriesAnswerBeans,
			String username) throws InsertException {
		for(TestSeriesAnswerBean testSeriesAnswerBean : testSeriesAnswerBeans) {
			TestSeriesAnswer testSeriesAnswer = testSeriesConverters.convertBeanToEntity(testSeriesAnswerBean, username);
			insertService.insert(testSeriesAnswer);
			for(TestSeriesLinkedAnswer testSeriesLinkedAnswer : testSeriesAnswerBean.getLinkedAnswers()) {
				insertService.insert(testSeriesLinkedAnswer);
			}
		}
		return true;
	}

	@Override
	public List<Question> fetchTestSeriesQuestions(long testSeriesId) throws FetchException {
		return fetchService.getQuestions(testSeriesId);
	}

	@Override
	public List<TestSeriesEnrollmentStatusBean> fetchTestSeriesEnrollmentStatus(String username) throws FetchException {
		return fetchService.getTestSeriesEnrollmentStatus(username);
	}
	
	@Override
	public List<TestSeriesAnswer> fetchTestSeriesAnswers(long testSeriesId, String username) throws FetchException {
		return fetchService.fetch(testSeriesId, username);
	}

}
