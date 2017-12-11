package com.wisdom.service.utility.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.dao.testseries.TestSeriesQuestionMapDao;
import com.wisdom.entity.testseries.TestSeriesQuestionMap;
import com.wisdom.exception.DeleteException;
import com.wisdom.service.utility.DeleteService;

public class DeleteServiceImpl implements DeleteService {

	@Autowired
	private TestSeriesQuestionMapDao testSeriesQuestionMapDao;
	
	@Override
	public void delete(TestSeriesQuestionMap testSeriesQuestionMap) throws DeleteException {
		testSeriesQuestionMapDao.delete(testSeriesQuestionMap);
	}

}
