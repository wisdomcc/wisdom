package com.wisdom.dao;

import java.util.List;

import com.wisdom.bean.QuestionFetchBean;
import com.wisdom.entity.Question;
import com.wisdom.exception.FetchException;

public interface NativeQueryQuestionDao {

	public List<Question> findByQuestionFetchBean(QuestionFetchBean questionFetchBean) throws FetchException;

}
