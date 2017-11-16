package com.wisdom.utility.converters.testseries;

import java.sql.Date;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.wisdom.bean.testseries.TestSeriesInsertBean;
import com.wisdom.bean.testseries.TestSeriesQuestionMapBean;
import com.wisdom.bean.testseries.TestSeriesUpdateBean;
import com.wisdom.entity.testseries.TestSeries;
import com.wisdom.entity.testseries.TestSeriesQuestionMap;

@Mapper(componentModel = "spring")
public interface TestSeriesConverters {
	
	public TestSeries convertBeanToEntity(TestSeriesInsertBean bean);
	public TestSeries convertBeanToEntity(TestSeriesUpdateBean bean);
	@Mappings({
		@Mapping(target="assignedDate", expression = "java(new java.sql.Date(System.currentTimeMillis()))"),
		@Mapping(target="assignedBy", source="username")
	})
	public TestSeriesQuestionMap convertBeanToEntity(TestSeriesQuestionMapBean bean, String username);
	
}