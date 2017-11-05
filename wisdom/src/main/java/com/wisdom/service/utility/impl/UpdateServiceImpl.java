package com.wisdom.service.utility.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.dao.LinkedQuestionDao;
import com.wisdom.dao.QuestionDao;
import com.wisdom.dao.QuestionParagraphDao;
import com.wisdom.entity.LinkedQuestion;
import com.wisdom.entity.Question;
import com.wisdom.entity.QuestionParagraph;
import com.wisdom.exception.UpdateException;
import com.wisdom.service.utility.UpdateService;

public class UpdateServiceImpl implements UpdateService {

	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private LinkedQuestionDao linkedQuestionDao;
	
	@Autowired
	private QuestionParagraphDao questionParagraphDao;

	@Override
	public boolean update(Question question) throws UpdateException {
		Question q = questionDao.save(question);
		if(q != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean update(LinkedQuestion question) throws UpdateException {
		LinkedQuestion q = linkedQuestionDao.save(question);
		if(q != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean update(QuestionParagraph question) throws UpdateException {
		QuestionParagraph q = questionParagraphDao.save(question);
		if(q != null) {
			return true;
		}
		return false;
	}

}
