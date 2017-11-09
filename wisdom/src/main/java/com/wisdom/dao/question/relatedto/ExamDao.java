package com.wisdom.dao.question.relatedto;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.question.relatedto.Exam;

public interface ExamDao extends CrudRepository<Exam, Long> {
	
	public Exam findById(long id);
	public Exam findByExam(String exam);
	public List<Exam> findAll();

}
