package com.wisdom.dao;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.UserLogin;

public interface UserLoginDao extends CrudRepository<UserLogin, Integer>{
	
	public UserLogin findByUsername(String username);
	public UserLogin findByEmailId(String emailId);
	
}
