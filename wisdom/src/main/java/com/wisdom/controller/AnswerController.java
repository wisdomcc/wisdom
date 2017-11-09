package com.wisdom.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisdom.bean.answer.AnswerInsertBean;
import com.wisdom.bean.answer.AnswerUpdateBean;
import com.wisdom.service.entity.AnswerService;

@RestController
@RequestMapping(path = "/answer")
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;

	@RequestMapping(path = "/insert", method = RequestMethod.POST)
	public boolean insertQuestion(Principal principal, @RequestBody List<AnswerInsertBean> answerInsertBeanList) {
		return answerService.insertAnswers(answerInsertBeanList, principal.getName());
	}
	
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public boolean updateQuestion(Principal principal, @RequestBody List<AnswerUpdateBean> answerUpdateBeanList) {
		return answerService.updateAnswers(answerUpdateBeanList, principal.getName());
	}
}
