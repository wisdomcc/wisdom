package com.wisdom.dao.testseries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.testseries.TestSeriesLinkedAnswer;

public interface TestSeriesLinkedAnswerDao extends CrudRepository<TestSeriesLinkedAnswer, Long> {

	public TestSeriesLinkedAnswer findById(long id);
	public List<TestSeriesLinkedAnswer> findByParentAnswerId(long parentAnswerId);
	public List<TestSeriesLinkedAnswer> findAll();

}