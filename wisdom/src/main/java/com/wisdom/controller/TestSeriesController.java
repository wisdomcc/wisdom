package com.wisdom.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.bean.testseries.TestSeriesInsertBean;
import com.wisdom.bean.testseries.TestSeriesUpdateBean;
import com.wisdom.service.entity.TestSeriesService;

@RestController
@RequestMapping(path = "/testseries")
public class TestSeriesController {
	
	@Autowired
	private TestSeriesService testSeriesService;
	
	@RequestMapping(path = "/insert", method = RequestMethod.POST)
	public boolean insertTestSeries(Principal principal, @RequestBody List<TestSeriesInsertBean> testSeriesInsertBeanList) {
		return testSeriesService.insertTestSeries(testSeriesInsertBeanList, principal.getName());
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public boolean updateQuestion(Principal principal, @RequestBody List<TestSeriesUpdateBean> testSeriesUpdateBeanList) {
		return testSeriesService.updateTestSeries(testSeriesUpdateBeanList, principal.getName());
	}

}
