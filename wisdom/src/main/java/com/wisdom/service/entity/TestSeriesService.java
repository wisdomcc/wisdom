package com.wisdom.service.entity;

import java.util.List;

import com.wisdom.bean.testseries.TestSeriesInsertBean;
import com.wisdom.bean.testseries.TestSeriesQuestionMapBean;
import com.wisdom.bean.testseries.TestSeriesUpdateBean;
import com.wisdom.exception.InsertException;
import com.wisdom.exception.UpdateException;

public interface TestSeriesService {
	
	public boolean updateTestSeries(List<TestSeriesUpdateBean> questionUpdateBean, String username) throws UpdateException;
	public boolean insertTestSeries(List<TestSeriesInsertBean> questionInsertBeans, String username) throws InsertException;
	public boolean insertTestSeriesQuestionMap(List<TestSeriesQuestionMapBean> testSeriesQuestionMapBeans, String username) throws InsertException;

}
