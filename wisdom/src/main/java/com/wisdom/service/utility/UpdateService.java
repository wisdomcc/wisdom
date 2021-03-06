package com.wisdom.service.utility;

import com.wisdom.entity.answer.Answer;
import com.wisdom.entity.answer.LinkedAnswer;
import com.wisdom.entity.question.LinkedQuestion;
import com.wisdom.entity.question.Question;
import com.wisdom.entity.question.QuestionParagraph;
import com.wisdom.entity.testseries.TestSeries;
import com.wisdom.exception.UpdateException;

public interface UpdateService {

	public boolean update(Question question) throws UpdateException;
	public boolean update(LinkedQuestion linkedQuestion) throws UpdateException;
	public boolean update(QuestionParagraph questionParagraph) throws UpdateException;
	public boolean update(Answer answer) throws UpdateException;
	public boolean update(LinkedAnswer linkedAnswer) throws UpdateException;
	public boolean update(TestSeries testSeries) throws UpdateException;
	
}
