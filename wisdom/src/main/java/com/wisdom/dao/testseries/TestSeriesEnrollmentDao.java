package com.wisdom.dao.testseries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.testseries.TestSeriesEnrollment;

public interface TestSeriesEnrollmentDao extends CrudRepository<TestSeriesEnrollment, Long> {

	public TestSeriesEnrollment findById(long id);
	public List<TestSeriesEnrollment> findByTestSeriesId(long testSeriesId);
	public List<TestSeriesEnrollment> findByUsername(String username);
	public List<TestSeriesEnrollment> findAll();

}
