package com.wisdom.dao.question.relatedto;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.question.relatedto.Topic;

public interface TopicDao extends CrudRepository<Topic, Long> {
	
	public Topic findById(long id);
	public Topic findByTopic(String topic);

}