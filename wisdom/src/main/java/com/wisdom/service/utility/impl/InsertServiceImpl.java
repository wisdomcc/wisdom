package com.wisdom.service.utility.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.dao.LinkedQuestionDao;
import com.wisdom.dao.QuestionDao;
import com.wisdom.dao.QuestionParagraphDao;
import com.wisdom.entity.LinkedQuestion;
import com.wisdom.entity.Question;
import com.wisdom.entity.QuestionParagraph;
import com.wisdom.exception.InsertException;
import com.wisdom.service.utility.InsertService;

public class InsertServiceImpl implements InsertService {
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private LinkedQuestionDao linkedQuestionDao;
	
	@Autowired
	private QuestionParagraphDao questionParagraphDao;

	@Override
	public boolean insert(Question question) throws InsertException {
		Question q = questionDao.save(question);
		if(q != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean insert(LinkedQuestion question) throws InsertException {
		LinkedQuestion q = linkedQuestionDao.save(question);
		if(q != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean insert(QuestionParagraph question) throws InsertException {
		QuestionParagraph q = questionParagraphDao.save(question);
		if(q != null) {
			return true;
		}
		return false;
	}

}
