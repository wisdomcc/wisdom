package com.wisdom.dao.testseries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.testseries.TestSeriesQuestionMap;

public interface TestSeriesQuestionMapDao extends CrudRepository<TestSeriesQuestionMap, Long> {

	public List<TestSeriesQuestionMap> findByTestSeriesId(long testSeriesId);
	public List<TestSeriesQuestionMap> findByQuestionId(long questionId);
	public TestSeriesQuestionMap findByTestSeriesIdAndQuestionId(long testSeriesId, long questionId);

}
