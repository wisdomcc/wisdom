package com.wisdom.dao.question;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.question.LinkedQuestion;

public interface LinkedQuestionDao extends CrudRepository<LinkedQuestion, Long> {
	
	public LinkedQuestion findById(long id);
	public List<LinkedQuestion> findByParentQuestionId(long id);

}
