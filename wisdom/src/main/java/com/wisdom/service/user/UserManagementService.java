package com.wisdom.service.user;

import com.wisdom.entity.UserLogin;

public interface UserManagementService {
	
	public UserLogin findUserByUsername(String username);
	public void addUser(String username, String emailId, String password);
	public boolean isUsernameExisting(String username);
	public boolean isEmailExisting(String emailId);
	public void updateUser(UserLogin userLogin);
	public boolean changePassword(String username, String oldPassword, String newPassword);

}
