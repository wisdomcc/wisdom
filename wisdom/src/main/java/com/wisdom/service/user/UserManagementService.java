package com.wisdom.service.user;

import com.wisdom.entity.UserLogin;

public interface UserManagementService {
	
	public UserLogin findUserByUsername(String username);
	//public UserLogin findUserByRandomToken(String randomToken);
	public void addUser(String username, String emailId, String password);
	public boolean isUsernameExisting(String username);
	public boolean isEmailExisting(String emailId);
	public void updateUser(UserLogin userLogin);
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
