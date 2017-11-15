package com.wisdom.dao.testseries;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.testseries.TestSeries;

public interface TestSeriesDao extends CrudRepository<TestSeries, Long> {

	public TestSeries findById(long id);

}
