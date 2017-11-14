package com.wisdom.service.entity.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.bean.question.QuestionFetchBean;
import com.wisdom.bean.question.QuestionInsertBean;
import com.wisdom.bean.question.QuestionUpdateBean;
import com.wisdom.entity.question.LinkedQuestion;
import com.wisdom.entity.question.Question;
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
	public Question getQuestion(int id) throws FetchException {
		return fetchService.getQuestion(id);
	}

	@Override
	public boolean updateQuestion(QuestionUpdateBean questionUpdateBean, String username) throws UpdateException {
		Question question = WisdomUtility.buildQuestion(questionUpdateBean, username);
		return updateService.update(question);
	}
	
	@Override
	public boolean updateQuestions(List<QuestionUpdateBean> questionUpdateBeans, String username) throws UpdateException {
		for(QuestionUpdateBean questionUpdateBean : questionUpdateBeans) {
			Question question = WisdomUtility.buildQuestion(questionUpdateBean, username);
			updateService.update(question);
			for(LinkedQuestion linkedQuestion : questionUpdateBean.getLinkedQuestions()) {
				updateService.update(linkedQuestion);
			}
			if(!questionUpdateBean.getParagraph().getParagraph().isEmpty()) {
				updateService.update(questionUpdateBean.getParagraph());
			}
		}
		return true;
	}

	@Override
	public boolean insertQuestion(QuestionInsertBean questionInsertBean, String username) throws InsertException {
		Question question = WisdomUtility.buildQuestion(questionInsertBean, username);
		return insertService.insert(question);
	}
	
	@Override
	public boolean insertQuestions(List<QuestionInsertBean> questionInsertBeans, String username) throws InsertException {
		for(QuestionInsertBean questionInsertBean : questionInsertBeans) {
			Question question = WisdomUtility.buildQuestion(questionInsertBean, username);
			insertService.insert(question);
			for(LinkedQuestion linkedQuestion : questionInsertBean.getLinkedQuestions()) {
				insertService.insert(linkedQuestion);
			}
			if(questionInsertBean.getParagraph() != null && 
				questionInsertBean.getParagraph().getParagraph() != null && 
					!questionInsertBean.getParagraph().getParagraph().isEmpty()) {
				insertService.insert(questionInsertBean.getParagraph());
			}
		}
		return true;
	}

	@Override
	public void print(List<Question> questions) throws PrintException {
		// TODO Auto-generated method stub
		
	}

}
