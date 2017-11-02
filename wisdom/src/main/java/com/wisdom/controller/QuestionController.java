package com.wisdom.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wisdom.bean.QuestionFetchBean;
import com.wisdom.bean.QuestionInsertBean;
import com.wisdom.dao.ExamDao;
import com.wisdom.entity.Exam;
import com.wisdom.entity.Question;
import com.wisdom.service.entity.QuestionService;
import com.wisdom.service.utility.UploadService;

@RestController
@RequestMapping(path = "/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private ExamDao examDao;

	@Autowired
	private UploadService uploadService;

	@RequestMapping(path = "/fetch", method = RequestMethod.POST)
	public List<Question> fetchQuestion(@RequestBody QuestionFetchBean questionRequestBean) {
		return questionService.getQuestions(questionRequestBean);
	}

	@RequestMapping(path = "/insert", method = RequestMethod.POST)
	public boolean insertQuestion(@RequestBody List<QuestionInsertBean> questionInsertBeanList) {
		return questionService.insertQuestions(questionInsertBeanList);
	}

	@RequestMapping(path = "/uploadImage", method = RequestMethod.POST)
	public ResponseEntity<String> uploadImage(HttpServletResponse res, @RequestParam(value = "file") MultipartFile file,
			@RequestParam(value = "questionid") String questionId, @RequestParam(value = "option") String option)
			throws IOException {
		String uploadedFilePath = uploadService.uploadImage(file, questionId, option);
		if (uploadedFilePath != null) {
			return new ResponseEntity<String>("{\"path\":\"" + uploadedFilePath + "\"}", HttpStatus.OK);
		}
		return new ResponseEntity<String>("{\"path\":\"" + uploadedFilePath + "\"}", HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(path = "/viewAllExam", method = RequestMethod.GET)
	public List<Exam> uploadImage(HttpServletResponse res) {
		return examDao.findAll();
	}

}
