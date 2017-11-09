package com.wisdom.service.utility.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.dao.answer.AnswerDao;
import com.wisdom.dao.answer.LinkedAnswerDao;
import com.wisdom.dao.question.LinkedQuestionDao;
import com.wisdom.dao.question.QuestionDao;
import com.wisdom.dao.question.QuestionParagraphDao;
import com.wisdom.entity.answer.Answer;
import com.wisdom.entity.answer.LinkedAnswer;
import com.wisdom.entity.question.LinkedQuestion;
import com.wisdom.entity.question.Question;
import com.wisdom.entity.question.QuestionParagraph;
import com.wisdom.exception.UpdateException;
import com.wisdom.service.utility.UpdateService;

public class UpdateServiceImpl implements UpdateService {

	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private LinkedQuestionDao linkedQuestionDao;
	
	@Autowired
	private QuestionParagraphDao questionParagraphDao;
	
	@Autowired
	private AnswerDao answerDao;
	
	@Autowired
	private LinkedAnswerDao linkedAnswerDao;

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
	
	@Override
	public boolean update(Answer answer) throws UpdateException {
		Answer q = answerDao.save(answer);
		if(q != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean update(LinkedAnswer linkedAnswer) throws UpdateException {
		LinkedAnswer q = linkedAnswerDao.save(linkedAnswer);
		if(q != null) {
			return true;
		}
		return false;
	}

}
