package com.wisdom.dao;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.SubTopic;

public interface SubTopicDao extends CrudRepository<SubTopic, Long> {
	
	public SubTopic findById(long id);
	public SubTopic findBySubTopic(String subTopic);

}
