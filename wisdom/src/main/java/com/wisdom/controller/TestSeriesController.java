package com.wisdom.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.bean.testseries.TestSeriesAnswerBean;
import com.wisdom.bean.testseries.TestSeriesEnrollmentBean;
import com.wisdom.bean.testseries.TestSeriesEnrollmentStatusBean;
import com.wisdom.bean.testseries.TestSeriesInsertBean;
import com.wisdom.bean.testseries.TestSeriesQuestionMapBean;
import com.wisdom.bean.testseries.TestSeriesUpdateBean;
import com.wisdom.dao.testseries.TestSeriesDao;
import com.wisdom.entity.question.Question;
import com.wisdom.entity.testseries.TestSeries;
import com.wisdom.entity.testseries.TestSeriesAnswer;
import com.wisdom.service.entity.TestSeriesService;

@RestController
@RequestMapping(path = "/testseries")
public class TestSeriesController {
	
	@Autowired
	private TestSeriesService testSeriesService;
	
	@Autowired
	private TestSeriesDao testSeriesDao;
	
	@RequestMapping(path = "/fetchanswer", method = RequestMethod.POST)
	public List<TestSeriesAnswer> fetchTestSeriesAnswer(Principal principal, @RequestParam long testSeriesId) {
		return testSeriesService.fetchTestSeriesAnswers(testSeriesId, principal.getName());
	}
	
	@RequestMapping(path = "/fetchall", method = RequestMethod.GET)
	public List<TestSeries> fetchAllTestSeries() {
		return testSeriesDao.findAll();
	}
	
	@RequestMapping(path = "/fetch", method = RequestMethod.GET)
	public List<TestSeriesEnrollmentStatusBean> fetchTestSeries(Principal principal) {
		return testSeriesService.fetchTestSeriesEnrollmentStatus(principal.getName());
	}
	
	@RequestMapping(path = "/fetchquestions", method = RequestMethod.POST)
	public List<Question> fetchTestSeriesQuestions(@RequestBody long testSeriesId) {
		return testSeriesService.fetchTestSeriesQuestions(testSeriesId);
	}
	
	@RequestMapping(path = "/enroll", method = RequestMethod.POST)
	public boolean enrollTestSeries(Principal principal, @RequestBody List<TestSeriesEnrollmentBean> testSeriesEnrollmentBeanList) {
		return testSeriesService.enrollTestSeries(testSeriesEnrollmentBeanList, principal.getName());
	}
	
	@RequestMapping(path = "/submit", method = RequestMethod.POST)
	public boolean submitTestSeries(Principal principal, @RequestBody List<TestSeriesAnswerBean> testSeriesAnswerBeanList) {
		return testSeriesService.submitTestSeries(testSeriesAnswerBeanList, principal.getName());
	}
	
	@RequestMapping(path = "/insertmap", method = RequestMethod.POST)
	public boolean insertTestSeriesQuestionMap(Principal principal, @RequestBody List<TestSeriesQuestionMapBean> testSeriesQuestionMapBeanList) {
		return testSeriesService.insertTestSeriesQuestionMap(testSeriesQuestionMapBeanList, principal.getName());
	}
	
	@RequestMapping(path = "/deletemap", method = RequestMethod.POST)
	public boolean deleteTestSeriesQuestionMap(Principal principal, @RequestBody List<TestSeriesQuestionMapBean> testSeriesQuestionMapBeanList) {
		return testSeriesService.deleteTestSeriesQuestionMap(testSeriesQuestionMapBeanList, principal.getName());
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
