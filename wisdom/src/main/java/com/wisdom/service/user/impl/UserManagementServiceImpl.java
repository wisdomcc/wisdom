package com.wisdom.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wisdom.dao.UserLoginDao;
import com.wisdom.entity.UserLogin;
import com.wisdom.service.user.UserManagementService;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	private UserLoginDao userLoginDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void addUser(String username, String email, String password) {
		UserLogin userLogin = new UserLogin(username, email, "student", passwordEncoder.encode(password));
		userLoginDao.save(userLogin);
	}

	@Override
	public void updateUser(UserLogin userLogin) {
		userLoginDao.save(userLogin);
	}

	@Override
	public UserLogin findUserByUsername(String username) {
		UserLogin userLogin = userLoginDao.findByUsername(username);
		if (userLogin != null) {
			userLogin.checkAndResetPreliminaries();
			userLoginDao.save(userLogin);
		}
		return userLogin;
	}

	@Override
	public boolean isUsernameExisting(String username) {
		UserLogin userLogin = userLoginDao.findByUsername(username);
		if (userLogin != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmailExisting(String emailId) {
		UserLogin userLogin = userLoginDao.findByEmailId(emailId);
		if (userLogin != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean changePassword(String username, String oldPassword, String newPassword) {
		UserLogin userLogin = userLoginDao.findByUsername(username);
		if (passwordEncoder.matches(oldPassword, userLogin.getPassword())) {
			userLogin.setOrUpdatePassword(passwordEncoder.encode(newPassword));
			userLoginDao.save(userLogin);
			return true;
		}
		return false;
	}

}
