package com.wisdom.service.entity.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.bean.testseries.TestSeriesInsertBean;
import com.wisdom.bean.testseries.TestSeriesUpdateBean;
import com.wisdom.entity.testseries.TestSeries;
import com.wisdom.exception.UpdateException;
import com.wisdom.service.entity.TestSeriesService;
import com.wisdom.service.utility.InsertService;
import com.wisdom.service.utility.UpdateService;
import com.wisdom.utility.WisdomUtility;

public class TestSeriesServiceImpl implements TestSeriesService {

	@Autowired
	private InsertService insertService;
	
	@Autowired
	private UpdateService updateService;
	
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

}
