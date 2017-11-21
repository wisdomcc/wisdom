package com.wisdom.service.utility.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisdom.bean.question.QuestionCategoryBean;
import com.wisdom.dao.answer.AnswerDao;
import com.wisdom.dao.answer.LinkedAnswerDao;
import com.wisdom.dao.question.LinkedQuestionDao;
import com.wisdom.dao.question.QuestionDao;
import com.wisdom.dao.question.QuestionParagraphDao;
import com.wisdom.dao.question.relatedto.ExamDao;
import com.wisdom.dao.question.relatedto.StreamDao;
import com.wisdom.dao.question.relatedto.SubTopicDao;
import com.wisdom.dao.question.relatedto.SubjectDao;
import com.wisdom.dao.question.relatedto.TopicDao;
import com.wisdom.dao.testseries.TestSeriesAnswerDao;
import com.wisdom.dao.testseries.TestSeriesDao;
import com.wisdom.dao.testseries.TestSeriesEnrollmentDao;
import com.wisdom.dao.testseries.TestSeriesLinkedAnswerDao;
import com.wisdom.dao.testseries.TestSeriesQuestionMapDao;
import com.wisdom.entity.answer.Answer;
import com.wisdom.entity.answer.LinkedAnswer;
import com.wisdom.entity.question.LinkedQuestion;
import com.wisdom.entity.question.Question;
import com.wisdom.entity.question.QuestionParagraph;
import com.wisdom.entity.question.relatedto.Exam;
import com.wisdom.entity.question.relatedto.Stream;
import com.wisdom.entity.question.relatedto.SubTopic;
import com.wisdom.entity.question.relatedto.Subject;
import com.wisdom.entity.question.relatedto.Topic;
import com.wisdom.entity.testseries.TestSeries;
import com.wisdom.entity.testseries.TestSeriesAnswer;
import com.wisdom.entity.testseries.TestSeriesEnrollment;
import com.wisdom.entity.testseries.TestSeriesLinkedAnswer;
import com.wisdom.entity.testseries.TestSeriesQuestionMap;
import com.wisdom.exception.InsertException;
import com.wisdom.service.utility.InsertService;

public class InsertServiceImpl implements InsertService {
	
	@Autowired
	private ExamDao examDao;
	
	@Autowired
	private StreamDao streamDao;
	
	@Autowired
	private SubjectDao subjectDao;
	
	@Autowired
	private TopicDao topicDao;
	
	@Autowired
	private SubTopicDao subtopicDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private LinkedQuestionDao linkedQuestionDao;
	
	@Autowired
	private QuestionParagraphDao questionParagraphDao;
	
	@Autowired
	private AnswerDao answerDao;
	
	@Autowired
	private LinkedAnswerDao linkedAnswerDao;
	
	@Autowired
	private TestSeriesDao testSeriesDao;
	
	@Autowired
	private TestSeriesQuestionMapDao testSeriesQuestionMapDao;
	
	@Autowired
	private TestSeriesEnrollmentDao testSeriesEnrollmentDao;
	
	@Autowired
	private TestSeriesAnswerDao testSeriesAnswerDao;
	
	@Autowired
	private TestSeriesLinkedAnswerDao testSeriesLinkedAnswerDao;

	@Override
	public boolean insert(Question question) throws InsertException {
		Question q = questionDao.save(question);
		if(q != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean insert(LinkedQuestion question) throws InsertException {
		LinkedQuestion q = linkedQuestionDao.save(question);
		if(q != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean insert(QuestionParagraph question) throws InsertException {
		QuestionParagraph q = questionParagraphDao.save(question);
		if(q != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean insert(Answer answer) throws InsertException {
		Answer q = answerDao.save(answer);
		if(q != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean insert(LinkedAnswer linkedAnswer) throws InsertException {
		LinkedAnswer q = linkedAnswerDao.save(linkedAnswer);
		if(q != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean insert(TestSeries testSeries) throws InsertException {
		TestSeries q = testSeriesDao.save(testSeries);
		if(q != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(TestSeriesQuestionMap testSeriesQuestionMap) throws InsertException {
		TestSeriesQuestionMap q = testSeriesQuestionMapDao.save(testSeriesQuestionMap);
		if(q != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(TestSeriesEnrollment testSeriesEnrollment) throws InsertException {
		TestSeriesEnrollment q = testSeriesEnrollmentDao.save(testSeriesEnrollment);
		if(q != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(TestSeriesAnswer testSeriesAnswer) throws InsertException {
		TestSeriesAnswer q = testSeriesAnswerDao.save(testSeriesAnswer);
		if(q != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(TestSeriesLinkedAnswer testSeriesLinkedAnswer) throws InsertException {
		TestSeriesLinkedAnswer q = testSeriesLinkedAnswerDao.save(testSeriesLinkedAnswer);
		if(q != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(QuestionCategoryBean questionCategoryBean) throws InsertException {
		Exam exam = examDao.findByExam(questionCategoryBean.getExam());
		if(exam == null) {
			exam = new Exam();
			exam.setExam(questionCategoryBean.getExam());
			exam = examDao.save(exam);
		}
		Stream stream = streamDao.findByStream(questionCategoryBean.getStream());
		if(stream == null) {
			stream = new Stream();
			stream.setStream(questionCategoryBean.getStream());
			stream.setExamId(exam.getId());
			stream = streamDao.save(stream);
		}
		Subject subject = subjectDao.findBySubject(questionCategoryBean.getSubject());
		if(subject == null) {
			subject = new Subject();
			subject.setSubject(questionCategoryBean.getSubject());
			subject.setStreamId(stream.getId());
			subject = subjectDao.save(subject);
		}
		Topic topic = topicDao.findByTopic(questionCategoryBean.getTopic());
		if(topic == null) {
			topic = new Topic();
			topic.setTopic(questionCategoryBean.getTopic());
			topic.setSubjectId(subject.getId());
			topic = topicDao.save(topic);
		}
		SubTopic subtopic = subtopicDao.findBySubTopic(questionCategoryBean.getSubtopic());
		if(subtopic == null) {
			subtopic = new SubTopic();
			subtopic.setSubTopic(questionCategoryBean.getSubtopic());
			subtopic.setTopicId(topic.getId());
			subtopic = subtopicDao.save(subtopic);
		}
		return true;
	}

}
