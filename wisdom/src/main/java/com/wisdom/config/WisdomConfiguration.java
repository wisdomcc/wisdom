package com.wisdom.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.wisdom.bean.QuestionImages;
import com.wisdom.bean.QuestionOptions;
import com.wisdom.bean.RelatedTo;
import com.wisdom.dao.NativeQueryQuestionDao;
import com.wisdom.dao.impl.NativeQueryQuestionDaoImpl;
import com.wisdom.entity.Question;
import com.wisdom.service.EmailService;
import com.wisdom.service.entity.QuestionService;
import com.wisdom.service.entity.impl.QuestionServiceImpl;
import com.wisdom.service.impl.EmailServiceImpl;
import com.wisdom.service.utility.FetchService;
import com.wisdom.service.utility.InsertService;
import com.wisdom.service.utility.UpdateService;
import com.wisdom.service.utility.UploadService;
import com.wisdom.service.utility.impl.FetchServiceImpl;
import com.wisdom.service.utility.impl.InsertServiceImpl;
import com.wisdom.service.utility.impl.UpdateServiceImpl;
import com.wisdom.service.utility.impl.UploadServiceImpl;
import com.wisdom.utility.json.JacksonUtil;

@Configuration
public class WisdomConfiguration {

	@Autowired
	DataSource dataSource;
	
	@Bean
	public Session emailSession() {
		// Create a Properties object to contain connection configuration
		// information.
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtp.port", emailProperties().getPort());

		// Set properties indicating that we want to use STARTTLS to encrypt the
		// connection.
		// The SMTP session will begin on an unencrypted connection, and then
		// the client
		// will issue a STARTTLS command to upgrade to an encrypted connection.
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.required", "true");

		// Create a Session object to represent a mail session with the
		// specified properties.
		Session session = Session.getDefaultInstance(props);
		return session;
	}

	@Bean
	public Transport emailTransport() throws MessagingException {
		Transport transport = emailSession().getTransport();
		return transport;
	}

	@Bean
	public EmailService emailService() {
		return new EmailServiceImpl();
	}
	
	@Bean
	public EmailProperties emailProperties() {
		return new EmailProperties();
	}
	@Bean
	public FetchService fetchService() {
		return new FetchServiceImpl();
	}

	@Bean
	public InsertService insertService() {
		return new InsertServiceImpl();
	}
	
	@Bean
	public UpdateService updateService() {
		return new UpdateServiceImpl();
	}
	
	@Bean
	public UploadService uploadService() {
		return new UploadServiceImpl();
	}

	@Bean
	public QuestionService questionService() {
		return new QuestionServiceImpl();
	}

	@Bean
	public NativeQueryQuestionDao customQuestionRepository() {
		return new NativeQueryQuestionDaoImpl();
	}

	@Bean
	public ResultSetExtractor<List<Question>> resultSetExtractor() {
		return new ResultSetExtractor<List<Question>>() {
			public List<Question> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				List<Question> qList = new ArrayList<Question>();
				while (resultSet.next()) {
					Question question = new Question();
					question.setId(resultSet.getLong("id"));
					question.setQuestion(resultSet.getString("question"));
					question.setHints(resultSet.getString("hints"));
					question.setType(resultSet.getString("type"));
					question.setOptions(JacksonUtil.fromString(resultSet.getString("options"), QuestionOptions.class));
					question.setImages(JacksonUtil.fromString(resultSet.getString("images"), QuestionImages.class));
					question.setYear(resultSet.getInt("year"));
					question.setMarks(resultSet.getInt("marks"));
					question.setRelatedTo(JacksonUtil.fromString(resultSet.getString("related_to"), RelatedTo.class));
					qList.add(question);
				}
				return qList;
			}
		};
	}

}
