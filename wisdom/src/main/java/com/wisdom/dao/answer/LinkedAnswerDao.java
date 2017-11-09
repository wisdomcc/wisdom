package com.wisdom.dao.answer;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.answer.LinkedAnswer;

public interface LinkedAnswerDao extends CrudRepository<LinkedAnswer, Long> {

	public LinkedAnswer findById(long id);

}
