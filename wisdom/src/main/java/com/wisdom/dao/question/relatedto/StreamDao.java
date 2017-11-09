package com.wisdom.dao.question.relatedto;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.question.relatedto.Stream;

public interface StreamDao extends CrudRepository<Stream, Long> {
	
	public Stream findById(long id);
	public Stream findByStream(String stream);

}
