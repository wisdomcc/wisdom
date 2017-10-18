package com.wisdom.dao;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.Stream;

public interface StreamDao extends CrudRepository<Stream, Long> {
	
	public Stream findById(long id);
	public Stream findByStream(String stream);

}
