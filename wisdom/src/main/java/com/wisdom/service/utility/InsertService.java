package com.wisdom.service.utility;

import com.wisdom.entity.Question;
import com.wisdom.exception.InsertException;

public interface InsertService {
	
	public boolean insert(Question question) throws InsertException;

}
