package com.wisdom.dao.question;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.question.QuestionParagraph;

public interface QuestionParagraphDao extends CrudRepository<QuestionParagraph, Long> {
	
	public QuestionParagraph findById(long id);
	public QuestionParagraph findByQuestionId(long id);

}
