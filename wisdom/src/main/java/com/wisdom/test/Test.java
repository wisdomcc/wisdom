/*package com.wisdom.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.wisdom.bean.QuestionImages;
import com.wisdom.bean.QuestionInsertBean;
import com.wisdom.bean.QuestionFetchBean;
import com.wisdom.bean.QuestionOptions;
import com.wisdom.bean.RelatedTo;
import com.wisdom.entity.Question;
import com.wisdom.utility.json.JacksonUtil;

public class Test {

	public static void main(String[] args) {
		Question question = new Question();
		question.setHints("hint");
		question.setYear(1999);
		question.setType("easy");
		List<String> exam = new ArrayList<String>();
		exam.add("gate");
		exam.add("net");
		List<String> subject = new ArrayList<String>();
		subject.add("os");
		subject.add("networking");
		List<String> option = new ArrayList<String>();
		option.add("option1");
		option.add("option2");
		option.add("option3");
		option.add("option4");
		RelatedTo relatedTo = new RelatedTo(exam, null, subject, null, null, null, null, null);
		question.setRelatedTo(relatedTo);
		question.setQuestion("what is GPS?");
		QuestionImages images = new QuestionImages(Arrays.asList("/p1.jpg", "/p2.jpg"));
		question.setImages(images);
		QuestionOptions options = new QuestionOptions("image", option, Arrays.asList("/o1.jpg", "/o2.jpg"));
		question.setOptions(options);
		QuestionFetchBean questionFetchBean = new QuestionFetchBean();
		QuestionInsertBean questionInsertBean = new QuestionInsertBean();
		questionInsertBean.setRelatedTo(relatedTo);
		questionInsertBean.setImages(images);
		questionInsertBean.setQuestion(question.getQuestion());
		questionInsertBean.setHints("hint");
		questionInsertBean.setMarks(5);
		questionInsertBean.setOptions(options);
		questionInsertBean.setType("easy");
		questionInsertBean.setYear(1999);
		questionFetchBean.setRelatedTo(relatedTo);
		System.out.println("QuestionFetchBean : " + questionFetchBean);
		System.out.println("RelatedTo : " + relatedTo);
		System.out.println("QuestionInsertBean : " + questionInsertBean);
		System.out.println("Question : " + JacksonUtil.toString(question));
	}

}
*/