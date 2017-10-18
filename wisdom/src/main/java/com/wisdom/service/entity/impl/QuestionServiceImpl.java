package com.wisdom.service.entity.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.bean.QuestionFetchBean;
import com.wisdom.bean.QuestionInsertBean;
import com.wisdom.bean.QuestionUpdateBean;
import com.wisdom.entity.Question;
import com.wisdom.exception.FetchException;
import com.wisdom.exception.InsertException;
import com.wisdom.exception.PrintException;
import com.wisdom.exception.UpdateException;
import com.wisdom.service.entity.QuestionService;
import com.wisdom.service.utility.FetchService;
import com.wisdom.service.utility.InsertService;
import com.wisdom.service.utility.UpdateService;
import com.wisdom.utility.WisdomUtility;

public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private FetchService fetchService;
	
	@Autowired
	private InsertService insertService;
	
	@Autowired
	private UpdateService updateService;

	@Override
	public List<Question> getQuestions(QuestionFetchBean questionRequestBean) throws FetchException {
		return fetchService.getQuestions(questionRequestBean);
	}
	
	@Override
	public List<Question> getQuestions(int id) throws FetchException {
		return fetchService.getQuestions(id);
	}

	@Override
	public boolean updateQuestion(QuestionUpdateBean questionUpdateBean) throws UpdateException {
		Question question = WisdomUtility.buildQuestion(questionUpdateBean);
		return updateService.update(question);
	}

	@Override
	public boolean insertQuestion(QuestionInsertBean questionInsertBean) throws InsertException {
		Question question = WisdomUtility.buildQuestion(questionInsertBean);
		return insertService.insert(question);
	}
	
	@Override
	public boolean insertQuestions(List<QuestionInsertBean> questionInsertBeans) throws InsertException {
		for(QuestionInsertBean questionInsertBean : questionInsertBeans) {
			Question question = WisdomUtility.buildQuestion(questionInsertBean);
			insertService.insert(question);
		}
		return true;
	}

	@Override
	public void print(List<Question> questions) throws PrintException {
		// TODO Auto-generated method stub
		
	}

}
