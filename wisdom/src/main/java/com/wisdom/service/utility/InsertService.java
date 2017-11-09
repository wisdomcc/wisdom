package com.wisdom.service.utility;

import com.wisdom.entity.answer.Answer;
import com.wisdom.entity.answer.LinkedAnswer;
import com.wisdom.entity.question.LinkedQuestion;
import com.wisdom.entity.question.Question;
import com.wisdom.entity.question.QuestionParagraph;
import com.wisdom.exception.InsertException;

public interface InsertService {
	
	public boolean insert(Question question) throws InsertException;
	public boolean insert(LinkedQuestion linkedQuestion) throws InsertException;
	public boolean insert(QuestionParagraph questionParagraph) throws InsertException;
	public boolean insert(Answer answer) throws InsertException;
	public boolean insert(LinkedAnswer linkedAnswer) throws InsertException;

}
