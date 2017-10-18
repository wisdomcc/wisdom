package com.wisdom.service.utility.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.dao.QuestionDao;
import com.wisdom.entity.Question;
import com.wisdom.exception.InsertException;
import com.wisdom.service.utility.InsertService;

public class InsertServiceImpl implements InsertService {
	
	@Autowired
	private QuestionDao questionDao;

	@Override
	public boolean insert(Question question) throws InsertException {
		Question q = questionDao.save(question);
		if(q != null) {
			return true;
		}
		return false;
	}

}
