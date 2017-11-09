package com.wisdom.service.entity;

import java.util.List;

import com.wisdom.bean.question.QuestionFetchBean;
import com.wisdom.bean.question.QuestionInsertBean;
import com.wisdom.bean.question.QuestionUpdateBean;
import com.wisdom.entity.question.Question;
import com.wisdom.exception.FetchException;
import com.wisdom.exception.InsertException;
import com.wisdom.exception.PrintException;
import com.wisdom.exception.UpdateException;

public interface QuestionService {

	public List<Question> getQuestions(QuestionFetchBean questionRequestBean) throws FetchException;
	public Question getQuestion(int id) throws FetchException;
	public boolean updateQuestion(QuestionUpdateBean questionUpdateBean, String username) throws UpdateException;
	public boolean updateQuestions(List<QuestionUpdateBean> questionUpdateBean, String username) throws UpdateException;
	public boolean insertQuestion(QuestionInsertBean questionInsertBean, String username) throws InsertException;
	public boolean insertQuestions(List<QuestionInsertBean> questionInsertBeans, String username) throws InsertException;
	public void print(List<Question> questions) throws PrintException;
	
}
