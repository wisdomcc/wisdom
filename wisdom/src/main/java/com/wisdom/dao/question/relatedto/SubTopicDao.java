package com.wisdom.dao.question.relatedto;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.question.relatedto.SubTopic;

public interface SubTopicDao extends CrudRepository<SubTopic, Long> {
	
	public SubTopic findById(long id);
	public SubTopic findBySubTopic(String subTopic);

}
