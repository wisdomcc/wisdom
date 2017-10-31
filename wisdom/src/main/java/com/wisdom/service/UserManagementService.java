package com.wisdom.service;

import com.wisdom.entity.UserLogin;

public interface UserManagementService {
	
	public UserLogin findUserByUsername(String username);
	//public UserLogin findUserByRandomToken(String randomToken);
	//public void addUser(UserBean userbean);
	//public void deleteUser(int userId);
	//public void resetLock(String username);
	//public void handleFailedLogin(String username);
	//public boolean changePassword(String username, String oldPassword, String newPassword);
	//public boolean resetPassword(String username, String newPassword);
	//public boolean handleRandomTokenToResetPassword(String randomToken);
	//public void generateRandomToken(String username, String emailId);
	//public void generateRandomToken(String username);
	//public void generateEmailWithRandomToken(String username);
}
