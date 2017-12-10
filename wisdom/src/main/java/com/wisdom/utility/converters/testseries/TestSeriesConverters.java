package com.wisdom.utility.converters.testseries;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.wisdom.bean.testseries.TestSeriesAnswerBean;
import com.wisdom.bean.testseries.TestSeriesEnrollmentBean;
import com.wisdom.bean.testseries.TestSeriesEnrollmentStatusBean;
import com.wisdom.bean.testseries.TestSeriesInsertBean;
import com.wisdom.bean.testseries.TestSeriesQuestionMapBean;
import com.wisdom.bean.testseries.TestSeriesUpdateBean;
import com.wisdom.entity.testseries.TestSeries;
import com.wisdom.entity.testseries.TestSeriesAnswer;
import com.wisdom.entity.testseries.TestSeriesEnrollment;
import com.wisdom.entity.testseries.TestSeriesQuestionMap;

@Mapper(componentModel = "spring")
public interface TestSeriesConverters {
	
	@Mappings({
		@Mapping(target="createdDate", expression = "java(new java.sql.Date(System.currentTimeMillis()))"),
		@Mapping(target="createdBy", source="username")
	})
	public TestSeries convertBeanToEntity(TestSeriesInsertBean bean, String username);
	
	@Mappings({
		@Mapping(target="createdDate", expression = "java(new java.sql.Date(System.currentTimeMillis()))"),
		@Mapping(target="createdBy", source="username")
	})
	public TestSeries convertBeanToEntity(TestSeriesUpdateBean bean, String username);
	
	@Mappings({
		@Mapping(target="assignedDate", expression = "java(new java.sql.Date(System.currentTimeMillis()))"),
		@Mapping(target="assignedBy", source="username")
	})
	public TestSeriesQuestionMap convertBeanToEntity(TestSeriesQuestionMapBean bean, String username);
	
	@Mappings({
		@Mapping(target="enrollmentDate", expression = "java(new java.sql.Date(System.currentTimeMillis()))"),
		@Mapping(target="username", source="username")
	})
	public TestSeriesEnrollment convertBeanToEntity(TestSeriesEnrollmentBean bean, String username);
	
	@Mappings({
		@Mapping(target="username", source="username")
	})
	public TestSeriesAnswer convertBeanToEntity(TestSeriesAnswerBean bean, String username);
	
	@Mappings({
		@Mapping(target="testSeriesStatus", source="testSeriesStatus"),
		@Mapping(target="enrollmentId", source="enrollmentId"),
		@Mapping(target="remainingExamDuration", source="remainingExamDuration")
	})
	public TestSeriesEnrollmentStatusBean convertTestSeriesToEnrollmentStatusBean(TestSeries testSeries, 
			String testSeriesStatus, int remainingExamDuration, long enrollmentId);
	
}