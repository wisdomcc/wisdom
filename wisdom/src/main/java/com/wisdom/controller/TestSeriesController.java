package com.wisdom.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.bean.testseries.TestSeriesEnrollmentBean;
import com.wisdom.bean.testseries.TestSeriesInsertBean;
import com.wisdom.bean.testseries.TestSeriesQuestionMapBean;
import com.wisdom.bean.testseries.TestSeriesUpdateBean;
import com.wisdom.dao.testseries.TestSeriesDao;
import com.wisdom.entity.testseries.TestSeries;
import com.wisdom.service.entity.TestSeriesService;

@RestController
@RequestMapping(path = "/testseries")
public class TestSeriesController {
	
	@Autowired
	private TestSeriesService testSeriesService;
	
	@Autowired
	private TestSeriesDao testSeriesDao;
	
	@RequestMapping(path = "/fetch", method = RequestMethod.GET)
	public List<TestSeries> fetchTestSeries() {
		return testSeriesDao.findAll();
	}
	
	@RequestMapping(path = "/enroll", method = RequestMethod.POST)
	public boolean enrollTestSeries(Principal principal, @RequestBody List<TestSeriesEnrollmentBean> testSeriesEnrollmentBeanList) {
		return testSeriesService.enrollTestSeries(testSeriesEnrollmentBeanList, principal.getName());
	}
	
	@RequestMapping(path = "/insertmap", method = RequestMethod.POST)
	public boolean insertTestSeriesQuestionMap(Principal principal, @RequestBody List<TestSeriesQuestionMapBean> testSeriesQuestionMapBeanList) {
		return testSeriesService.insertTestSeriesQuestionMap(testSeriesQuestionMapBeanList, principal.getName());
	}
	
	@RequestMapping(path = "/insert", method = RequestMethod.POST)
	public boolean insertTestSeries(Principal principal, @RequestBody List<TestSeriesInsertBean> testSeriesInsertBeanList) {
		return testSeriesService.insertTestSeries(testSeriesInsertBeanList, principal.getName());
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public boolean updateQuestion(Principal principal, @RequestBody List<TestSeriesUpdateBean> testSeriesUpdateBeanList) {
		return testSeriesService.updateTestSeries(testSeriesUpdateBeanList, principal.getName());
	}

}
