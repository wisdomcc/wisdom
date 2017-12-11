package com.wisdom.service.entity;

import java.util.List;

import com.wisdom.bean.testseries.TestSeriesAnswerBean;
import com.wisdom.bean.testseries.TestSeriesEnrollmentBean;
import com.wisdom.bean.testseries.TestSeriesEnrollmentStatusBean;
import com.wisdom.bean.testseries.TestSeriesInsertBean;
import com.wisdom.bean.testseries.TestSeriesQuestionMapBean;
import com.wisdom.bean.testseries.TestSeriesUpdateBean;
import com.wisdom.entity.question.Question;
import com.wisdom.entity.testseries.TestSeriesAnswer;
import com.wisdom.exception.DeleteException;
import com.wisdom.exception.FetchException;
import com.wisdom.exception.InsertException;
import com.wisdom.exception.UpdateException;

public interface TestSeriesService {
	
	public boolean updateTestSeries(List<TestSeriesUpdateBean> questionUpdateBean, String username) throws UpdateException;
	public boolean insertTestSeries(List<TestSeriesInsertBean> questionInsertBeans, String username) throws InsertException;
	public boolean insertTestSeriesQuestionMap(List<TestSeriesQuestionMapBean> testSeriesQuestionMapBeans, String username) throws InsertException;
	public boolean enrollTestSeries(List<TestSeriesEnrollmentBean> testSeriesEnrollmentBeans, String username) throws InsertException;
	public boolean submitTestSeries(List<TestSeriesAnswerBean> testSeriesAnswerBeans, String username) throws InsertException;
	public List<Question> fetchTestSeriesQuestions(long testSeriesId) throws FetchException;
	public List<TestSeriesEnrollmentStatusBean> fetchTestSeriesEnrollmentStatus(String username) throws FetchException;
	public List<TestSeriesAnswer> fetchTestSeriesAnswers(long testSeriesId, String username) throws FetchException;
	public boolean deleteTestSeriesQuestionMap(List<TestSeriesQuestionMapBean> testSeriesQuestionMapBeans, String username) throws DeleteException;
	
}
