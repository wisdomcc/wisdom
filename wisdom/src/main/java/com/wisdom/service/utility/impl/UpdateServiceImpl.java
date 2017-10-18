package com.wisdom.service.utility.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.dao.QuestionDao;
import com.wisdom.entity.Question;
import com.wisdom.exception.UpdateException;
import com.wisdom.service.utility.UpdateService;

public class UpdateServiceImpl implements UpdateService {

	@Autowired
	private QuestionDao questionDao;

	@Override
	public boolean update(Question question) throws UpdateException {
		Question q = questionDao.save(question);
		if(q != null) {
			return true;
		}
		return false;
	}

}
