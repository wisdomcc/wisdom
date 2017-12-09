package com.wisdom.dao.testseries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.testseries.TestSeriesAnswer;

public interface TestSeriesAnswerDao extends CrudRepository<TestSeriesAnswer, Long> {

	public TestSeriesAnswer findById(long id);
	public List<TestSeriesAnswer> findByTestSeriesId(long testSeriesId);
	public List<TestSeriesAnswer> findAll();
	public List<TestSeriesAnswer> findByTestSeriesIdAndUsername(long testSeriesId, String username);

}
