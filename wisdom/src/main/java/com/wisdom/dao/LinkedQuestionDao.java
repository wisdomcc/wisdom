package com.wisdom.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.LinkedQuestion;

public interface LinkedQuestionDao extends CrudRepository<LinkedQuestion, Long> {
	
	public LinkedQuestion findById(long id);
	public List<LinkedQuestion> findByParentQuestionId(long id);

}
