package com.wisdom.service.utility;

import java.util.List;

import com.wisdom.bean.QuestionFetchBean;
import com.wisdom.entity.Question;
import com.wisdom.exception.FetchException;

public interface FetchService {

	public List<Question> getQuestions(QuestionFetchBean questionRequestBean) throws FetchException;
	public List<Question> getQuestions(int id) throws FetchException;
	
}
