package com.wisdom.service.utility;

import com.wisdom.entity.LinkedQuestion;
import com.wisdom.entity.Question;
import com.wisdom.entity.QuestionParagraph;
import com.wisdom.exception.UpdateException;

public interface UpdateService {

	public boolean update(Question question) throws UpdateException;
	public boolean update(LinkedQuestion linkedQuestion) throws UpdateException;
	public boolean update(QuestionParagraph questionParagraph) throws UpdateException;
	
}
