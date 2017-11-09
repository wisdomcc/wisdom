package com.wisdom.service.entity;

import java.util.List;

import com.wisdom.bean.answer.AnswerInsertBean;
import com.wisdom.bean.answer.AnswerUpdateBean;
import com.wisdom.exception.InsertException;
import com.wisdom.exception.UpdateException;

public interface AnswerService {
	
	public boolean updateAnswers(List<AnswerUpdateBean> answerUpdateBeans, String username) throws UpdateException;
	public boolean insertAnswers(List<AnswerInsertBean> answerInsertBeans, String username) throws InsertException;

}
