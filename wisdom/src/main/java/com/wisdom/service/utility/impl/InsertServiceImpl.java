package com.wisdom.service.utility.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.dao.answer.AnswerDao;
import com.wisdom.dao.answer.LinkedAnswerDao;
import com.wisdom.dao.question.LinkedQuestionDao;
import com.wisdom.dao.question.QuestionDao;
import com.wisdom.dao.question.QuestionParagraphDao;
import com.wisdom.dao.testseries.TestSeriesDao;
import com.wisdom.dao.testseries.TestSeriesEnrollmentDao;
import com.wisdom.dao.testseries.TestSeriesQuestionMapDao;
import com.wisdom.entity.answer.Answer;
import com.wisdom.entity.answer.LinkedAnswer;
import com.wisdom.entity.question.LinkedQuestion;
import com.wisdom.entity.question.Question;
import com.wisdom.entity.question.QuestionParagraph;
import com.wisdom.entity.testseries.TestSeries;
import com.wisdom.entity.testseries.TestSeriesEnrollment;
import com.wisdom.entity.testseries.TestSeriesQuestionMap;
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
	
	@Autowired
	private LinkedAnswerDao linkedAnswerDao;
	
	@Autowired
	private TestSeriesDao testSeriesDao;
	
	@Autowired
	private TestSeriesQuestionMapDao testSeriesQuestionMapDao;
	
	@Autowired
	private TestSeriesEnrollmentDao testSeriesEnrollmentDao;

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
	
	@Override
	public boolean insert(LinkedAnswer linkedAnswer) throws InsertException {
		LinkedAnswer q = linkedAnswerDao.save(linkedAnswer);
		if(q != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean insert(TestSeries testSeries) throws InsertException {
		TestSeries q = testSeriesDao.save(testSeries);
		if(q != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(TestSeriesQuestionMap testSeriesQuestionMap) throws InsertException {
		TestSeriesQuestionMap q = testSeriesQuestionMapDao.save(testSeriesQuestionMap);
		if(q != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(TestSeriesEnrollment testSeriesEnrollment) throws InsertException {
		TestSeriesEnrollment q = testSeriesEnrollmentDao.save(testSeriesEnrollment);
		if(q != null) {
			return true;
		}
		return false;
	}

}
