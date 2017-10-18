package com.wisdom.dao;

import org.springframework.data.repository.CrudRepository;
import com.wisdom.entity.Subject;

public interface SubjectDao extends CrudRepository<Subject, Long> {
	
	public Subject findById(long id);
	public Subject findBySubject(String subject);

}