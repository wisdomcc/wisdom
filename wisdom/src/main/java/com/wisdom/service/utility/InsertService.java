package com.wisdom.service.utility;

import com.wisdom.entity.LinkedQuestion;
import com.wisdom.entity.Question;
import com.wisdom.entity.QuestionParagraph;
import com.wisdom.exception.InsertException;

public interface InsertService {
	
	public boolean insert(Question question) throws InsertException;
	public boolean insert(LinkedQuestion linkedQuestion) throws InsertException;
	public boolean insert(QuestionParagraph questionParagraph) throws InsertException;

}
