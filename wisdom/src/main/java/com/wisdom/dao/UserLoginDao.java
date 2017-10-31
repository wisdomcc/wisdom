package com.wisdom.dao;

import org.springframework.data.repository.CrudRepository;

import com.wisdom.entity.UserLogin;


/**
 * Created by EZDI\ganesh.s on 23/9/16.
 */
public interface UserLoginDao extends CrudRepository<UserLogin, Integer>{
	
	public UserLogin findByUsername(String username);
	
}
