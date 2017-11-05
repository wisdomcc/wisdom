package com.wisdom.dao;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.QuestionParagraph;

public interface QuestionParagraphDao extends CrudRepository<QuestionParagraph, Long> {
	
	public QuestionParagraph findById(long id);
	public QuestionParagraph findByQuestionId(long id);

}
