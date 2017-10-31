package com.wisdom.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wisdom.dao.UserLoginDao;
import com.wisdom.entity.UserLogin;
import com.wisdom.service.UserManagementService;


@Service
public class UserManagementServiceImpl implements UserManagementService{
	
	private static Logger logger = LogManager.getLogger(UserManagementServiceImpl.class);

	@Autowired
	private UserLoginDao userLoginDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//@PreAuthorize()
	/*@Override
	public void addUser(UserBean userBean){
		UserLogin userLogin = new UserLogin(userBean.getUsername(), userBean.getEmailId(), userBean.getTenantId(), userBean.getTenantName(), userBean.getLockExpirationTimeInMin(), userBean.getMaxCountForLock(), userBean.getPasswordExpireDays(), userBean.getEmrGlobalId(), userBean.getTokenExpireDate());
		userLoginDao.save(userLogin);
	}
	
	@Override
	public void deleteUser(int id){
		//TODO
	}
	
	@Override
	public void resetLock(String username){
		UserLogin userLogin = userLoginDao.findByUsername(username);
		if(userLogin != null){
			if(userLogin.getLoginFailedCount() > 0 || userLogin.isLocked()){
				userLogin.setLoginFailedCount(0);
				userLogin.setLocked(false);
				userLoginDao.save(userLogin);
			}
		}
	}
	
	@Override
	public boolean resetPassword(String username, String newPassword){
		UserLogin userLogin = userLoginDao.findByUsername(username);
		if(userLogin == null){
			throw new UsernameNotFoundException("No username '"+username+"' found.");
		}
		userLogin.setOrUpdatePassword(passwordEncoder.encode(newPassword));
		userLoginDao.save(userLogin);
		setSecurityContext(userLogin);
		return true;
	}
	
	@Override
	public void generateEmailWithRandomToken(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean changePassword(String username, String oldPassword, String newPassword){
		UserLogin userLogin = userLoginDao.findByUsername(username);
		//if(userLogin.getPassword().equals(passwordEncoder.encode(oldPassword))){
		if(userLogin == null){
			throw new UsernameNotFoundException("No username '"+username+"' found.");
		}
		if(passwordEncoder.matches(oldPassword, userLogin.getPassword())){
			logger.debug("Passwords Matched.. Updating Password for username '{}'",username);
			userLogin.setOrUpdatePassword(passwordEncoder.encode(newPassword));
			userLoginDao.save(userLogin);
			return true;
		}
		else{
			logger.debug("Supplied old password and existing password DO NOT MATCH for username '{}'.",username);
		}
		return false;
	}
	
	

	@Override
	public void generateRandomToken(String username, String emailId) {
		boolean isRandomTokenGenerated = false;
		if(username != null && emailId != null && !username.isEmpty() && !emailId.isEmpty()){
			UserLogin userLogin = userLoginDao.findByUsername(username);
			if(userLogin != null){
				if(emailId.equals(userLogin.getEmailId())){
					userLogin.createRandomToken(null);
					userLoginDao.save(userLogin);
					isRandomTokenGenerated = true;
				}
			}
		}
		if(!isRandomTokenGenerated){
			throw new UsernameNotFoundException("No user with username '"+username+"' and emailId '"
					+emailId+"' found.");
		}
		
	}
	
	@Override
	public void generateRandomToken(String username) {
		boolean isRandomTokenGenerated = false;
		if(username != null && !username.isEmpty()){
			UserLogin userLogin = userLoginDao.findByUsername(username);
			if(userLogin != null){
				userLogin.createRandomToken(null);
				userLoginDao.save(userLogin);
				isRandomTokenGenerated = true;
			}
		}
		if(!isRandomTokenGenerated){
			throw new UsernameNotFoundException("No user with username '"+username+"' found.");
		}
	}

	@Override
	public void handleFailedLogin(String username) {
		UserLogin userLogin = userLoginDao.findByUsername(username);
		if(userLogin != null){
			int failedCount = userLogin.getLoginFailedCount() + 1;
			userLogin.setLoginFailedCount(failedCount);
			int maxCountForLock = userLogin.getMaxCountForLock();
			if(failedCount >= maxCountForLock){
				userLogin.setLocked(true);
			}
			userLoginDao.save(userLogin);
		}
	}
*/
	@Override
	public UserLogin findUserByUsername(String username) {
		UserLogin userLogin = userLoginDao.findByUsername(username);
		if(userLogin != null){
			userLogin.checkAndResetPreliminaries();
			userLoginDao.save(userLogin);
		}
		return userLogin;
	}

	/*@Override
	public UserLogin findUserByRandomToken(String randomToken) {
		UserLogin userLogin = userLoginDao.findByRandomToken(randomToken);
		return userLogin;
	}
	
	@Override
	public boolean handleRandomTokenToResetPassword(String randomToken){
		UserLogin userLogin = findUserByRandomToken(randomToken);
		if(userLogin != null){
			setSecurityContext(userLogin);
			return true;
		}
		return false;
	}
	
	private void setSecurityContext(UserLogin userLogin){
		SecurityContextHolder.setContext(createSecurityContext(userLogin));
	}
	
	private SecurityContext createSecurityContext(UserLogin userLogin){
		if(userLogin == null){
			return null;
		}
		CustomUser user = new CustomUser(userLogin.getUsername(), userLogin.getPassword(), 
				userLogin.isEnabled(), !userLogin.isExpired(), !userLogin.isPasswordExpired(),
				!userLogin.isLocked(), getGrantedAuthorities(), userLogin.getId(), 
				userLogin.getTenantId(), userLogin.getTenantName(), userLogin.getEmailId(), userLogin.getMaxConcurrentSessions());
		UsernamePasswordAuthenticationToken authentication = 
				new UsernamePasswordAuthenticationToken(user, userLogin.getPassword(), getGrantedAuthorities());
		SecurityContext sc = new SecurityContextImpl();
		sc.setAuthentication(authentication);
		return sc;
	}
	
	private Collection<? extends GrantedAuthority> getGrantedAuthorities(){
		//TODO
		
		 * GET Role from ezAdmin
		 
		Set<SimpleGrantedAuthority> ret = new HashSet<>();
		SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("SUPERMAN");
		ret.add(grantedAuthority);
		grantedAuthority = new SimpleGrantedAuthority("BATMAN");
		ret.add(grantedAuthority);
		return ret;
	}
	
	private boolean checkAccess(int facilityId){
		//CustomUser currentUser = currentUserProviderService.getUser();
		//TODO
		return true;
	}
	
	public List<UserLogin> getAllUsers(){
		Iterable<UserLogin> userLoginList = userLoginDao.findAll();
		List<UserLogin> ret = new ArrayList<>();
		for(UserLogin each: userLoginList){
			ret.add(each);
		}
		return ret;
	}*/
}
