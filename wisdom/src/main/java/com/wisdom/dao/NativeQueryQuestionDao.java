package com.wisdom.dao;

import java.util.List;

import com.wisdom.bean.question.QuestionFetchBean;
import com.wisdom.entity.question.Question;
import com.wisdom.exception.FetchException;

public interface NativeQueryQuestionDao {

	public List<Question> findByQuestionFetchBean(QuestionFetchBean questionFetchBean) throws FetchException;

}
