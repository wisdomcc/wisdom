package com.wisdom.service.entity;

import java.util.List;

import com.wisdom.bean.QuestionFetchBean;
import com.wisdom.bean.QuestionInsertBean;
import com.wisdom.bean.QuestionUpdateBean;
import com.wisdom.entity.Question;
import com.wisdom.exception.FetchException;
import com.wisdom.exception.InsertException;
import com.wisdom.exception.PrintException;
import com.wisdom.exception.UpdateException;

public interface QuestionService {

	public List<Question> getQuestions(QuestionFetchBean questionRequestBean) throws FetchException;
	public List<Question> getQuestions(int id) throws FetchException;
	public boolean updateQuestion(QuestionUpdateBean questionUpdateBean, String username) throws UpdateException;
	public boolean updateQuestions(List<QuestionUpdateBean> questionUpdateBean, String username) throws UpdateException;
	public boolean insertQuestion(QuestionInsertBean questionInsertBean, String username) throws InsertException;
	public boolean insertQuestions(List<QuestionInsertBean> questionInsertBeans, String username) throws InsertException;
	public void print(List<Question> questions) throws PrintException;
	
}
