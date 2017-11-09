package com.wisdom.service.entity.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.bean.answer.AnswerInsertBean;
import com.wisdom.bean.answer.AnswerUpdateBean;
import com.wisdom.entity.answer.Answer;
import com.wisdom.entity.answer.LinkedAnswer;
import com.wisdom.exception.InsertException;
import com.wisdom.exception.UpdateException;
import com.wisdom.service.entity.AnswerService;
import com.wisdom.service.utility.InsertService;
import com.wisdom.service.utility.UpdateService;
import com.wisdom.utility.WisdomUtility;

public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	private InsertService insertService;
	
	@Autowired
	private UpdateService updateService;

	@Override
	public boolean updateAnswers(List<AnswerUpdateBean> answerUpdateBeans, String username) throws UpdateException {
		for(AnswerUpdateBean answerUpdateBean : answerUpdateBeans) {
			Answer answer = WisdomUtility.buildQuestion(answerUpdateBean, username);
			updateService.update(answer);
			if(!answerUpdateBean.getLinkedAnswers().isEmpty()) {
				for(LinkedAnswer linkedAnswer: answerUpdateBean.getLinkedAnswers()) {
					updateService.update(linkedAnswer);
				}
			}
		}
		return true;
	}

	@Override
	public boolean insertAnswers(List<AnswerInsertBean> answerInsertBeans, String username) throws InsertException {
		for(AnswerInsertBean answerInsertBean : answerInsertBeans) {
			Answer answer = WisdomUtility.buildQuestion(answerInsertBean, username);
			insertService.insert(answer);
			if(!answerInsertBean.getLinkedAnswers().isEmpty()) {
				for(LinkedAnswer linkedAnswer: answerInsertBean.getLinkedAnswers()) {
					insertService.insert(linkedAnswer);
				}
			}
		}
		return false;
	}

}
