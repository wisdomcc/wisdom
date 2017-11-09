package com.wisdom.service.utility.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.dao.answer.AnswerDao;
import com.wisdom.dao.question.LinkedQuestionDao;
import com.wisdom.dao.question.QuestionDao;
import com.wisdom.dao.question.QuestionParagraphDao;
import com.wisdom.entity.answer.Answer;
import com.wisdom.entity.question.LinkedQuestion;
import com.wisdom.entity.question.Question;
import com.wisdom.entity.question.QuestionParagraph;
import com.wisdom.exception.InsertException;
import com.wisdom.service.utility.InsertService;

public class InsertServiceImpl implements InsertService {
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private LinkedQuestionDao linkedQuestionDao;
	
	@Autowired
	private QuestionParagraphDao questionParagraphDao;
	
	@Autowired
	private AnswerDao answerDao;

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
	
	@Override
	public boolean insert(Answer answer) throws InsertException {
		Answer q = answerDao.save(answer);
		if(q != null) {
			return true;
		}
		return false;
	}

}
