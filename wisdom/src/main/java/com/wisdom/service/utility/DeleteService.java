package com.wisdom.service.utility;

import com.wisdom.entity.testseries.TestSeriesQuestionMap;
import com.wisdom.exception.DeleteException;

public interface DeleteService {

	public void delete(TestSeriesQuestionMap testSeriesQuestionMap) throws DeleteException;

}
