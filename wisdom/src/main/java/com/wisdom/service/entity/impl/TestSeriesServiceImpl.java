package com.wisdom.service.entity.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.bean.testseries.TestSeriesInsertBean;
import com.wisdom.bean.testseries.TestSeriesQuestionMapBean;
import com.wisdom.bean.testseries.TestSeriesUpdateBean;
import com.wisdom.entity.testseries.TestSeries;
import com.wisdom.entity.testseries.TestSeriesQuestionMap;
import com.wisdom.exception.InsertException;
import com.wisdom.exception.UpdateException;
import com.wisdom.service.entity.TestSeriesService;
import com.wisdom.service.utility.InsertService;
import com.wisdom.service.utility.UpdateService;
import com.wisdom.utility.WisdomUtility;
import com.wisdom.utility.converters.testseries.TestSeriesConverters;

public class TestSeriesServiceImpl implements TestSeriesService {

	@Autowired
	private InsertService insertService;
	
	@Autowired
	private UpdateService updateService;
	
	@Autowired
	private TestSeriesConverters testSeriesConverters;
	
	@Override
	public boolean updateTestSeries(List<TestSeriesUpdateBean> testSeriesUpdateBeans, String username)
			throws UpdateException {
		for(TestSeriesUpdateBean testSeriesUpdateBean : testSeriesUpdateBeans) {
			TestSeries testSeries = WisdomUtility.buildQuestion(testSeriesUpdateBean, username);
			updateService.update(testSeries);
		}
		return true;
	}

	@Override
	public boolean insertTestSeries(List<TestSeriesInsertBean> testSeriesInsertBeans, String username)
			throws UpdateException {
		for(TestSeriesInsertBean testSeriesInsertBean : testSeriesInsertBeans) {
			TestSeries testSeries = WisdomUtility.buildQuestion(testSeriesInsertBean, username);
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

}
