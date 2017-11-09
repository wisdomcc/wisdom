package com.wisdom.dao.answer;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.answer.Answer;

public interface AnswerDao extends CrudRepository<Answer, Long> {

	public Answer findById(long id);

}
