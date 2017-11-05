package com.wisdom.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.wisdom.bean.QuestionFetchBean;
import com.wisdom.dao.NativeQueryQuestionDao;
import com.wisdom.dao.QuestionDao;
import com.wisdom.entity.Question;
import com.wisdom.exception.FetchException;
import com.wisdom.utility.WisdomUtility;

public class NativeQueryQuestionDaoImpl implements NativeQueryQuestionDao, InitializingBean {

	@Autowired
	private ResultSetExtractor<List<Question>> resultSetExtractor;

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private QuestionDao questionDao;

	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Question> findByQuestionFetchBean(QuestionFetchBean questionFetchBean) {
		if(questionFetchBean.getRelatedTo() == null) {
			throw new FetchException("relatedTo must be available in json.");
		}
		Map<Integer, Object> queryMap = WisdomUtility.buildQuery(questionFetchBean);
		System.out.println("Fetch Query : " + (String) queryMap.get(queryMap.size()));
		List<Question> processedSearchResults = new ArrayList<Question>();
		List<Question> searchResults = jdbcTemplate.query((String) queryMap.get(queryMap.size()),
				new PreparedStatementSetter() {
					public void setValues(PreparedStatement preparedStatement) throws SQLException {
						for (int index = 1; index < queryMap.size(); index++) {
							if (queryMap.get(index) instanceof String) {
								preparedStatement.setString(index, (String) queryMap.get(index));
							} else if (queryMap.get(index) instanceof Integer) {
								preparedStatement.setInt(index, (Integer) queryMap.get(index));
							}
						}
						System.out.println("Final Query : " + preparedStatement.toString());
					}
				}, resultSetExtractor);
		for(Question question: searchResults) {
			processedSearchResults.add(questionDao.findById(question.getId()));
		}
		return processedSearchResults;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
