package com.wisdom.dao.question.relatedto;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.question.relatedto.Subject;

public interface SubjectDao extends CrudRepository<Subject, Long> {
	
	public Subject findById(long id);
	public Subject findBySubject(String subject);

}