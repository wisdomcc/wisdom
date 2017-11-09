package com.wisdom.service.utility.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.bean.question.QuestionFetchBean;
import com.wisdom.dao.NativeQueryQuestionDao;
import com.wisdom.dao.question.QuestionDao;
import com.wisdom.entity.question.Question;
import com.wisdom.exception.FetchException;
import com.wisdom.service.utility.FetchService;

public class FetchServiceImpl implements FetchService {
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private NativeQueryQuestionDao nativeQueryQuestionDao;

	@Override
	public List<Question> getQuestions(QuestionFetchBean questionRequestBean) throws FetchException {
		return nativeQueryQuestionDao.findByQuestionFetchBean(questionRequestBean);
	}

	@Override
	public Question getQuestion(int id) throws FetchException {
		return questionDao.findById(id);
	}

}
