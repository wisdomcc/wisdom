package com.wisdom.dao;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.Topic;

public interface TopicDao extends CrudRepository<Topic, Long> {
	
	public Topic findById(long id);
	public Topic findByTopic(String topic);

}