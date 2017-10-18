package com.wisdom.service.utility;

import com.wisdom.entity.Question;
import com.wisdom.exception.UpdateException;

public interface UpdateService {

	public boolean update(Question question) throws UpdateException;
	
}
