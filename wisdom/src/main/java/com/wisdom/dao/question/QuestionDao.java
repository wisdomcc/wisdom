package com.wisdom.dao.question;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.bean.question.RelatedTo;
import com.wisdom.entity.question.Question;

public interface QuestionDao extends CrudRepository<Question, Long> {

	public Question findById(long id);

	public List<Question> findByYearBetweenAndRelatedTo(int fromYear, int toYear, RelatedTo relatedTo);

	public List<Question> findByYearBetween(int fromYear, int toYear);

	public List<Question> findByType(String type);

}
