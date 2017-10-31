package com.wisdom.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wisdom.utility.RandomCreationUtil;

@Entity
@Table(name="user")
public class UserLogin {
	
	public UserLogin(){}
	
	public UserLogin(String username, String emailId, String role, int lockExpirationTimeInMin, 
			int maxCountForLock, int passwordExpireDays, Date tokenExpiryDate){
		
		this.username = username;
		this.password = "$2a$10$qAfD6rqe0OuoC7NhlO3bA.I.2hfWYHfJ/3dqwJZIRZAJUP3eSPtV6";
		this.emailId = emailId;
		this.role = role;
		this.isLocked = false;
		this.lockExpirationTimeInMin = lockExpirationTimeInMin;
		this.lastLoginAttemptDateTime = Calendar.getInstance().getTime();
		this.maxCountForLock = maxCountForLock;
		this.loginFailedCount = 0;
		this.status = DISABLED;
		this.reasonForStatus = "Newly created user.";
		this.isPasswordExpired = true;
		this.lastPasswordChangedDate = Calendar.getInstance().getTime();
		this.passwordExpireDays = passwordExpireDays;
		this.passwordResetFlag = true;
		this.maxConcurrentSessions=1;
		createRandomToken(tokenExpiryDate);
	}
	 
	
	
	private static Logger logger = LogManager.getLogger(UserLogin.class);
	
	public static final int ENABLED = 1;
	public static final int DISABLED = 2;
	public static final int EXPIRED = 3;
	public static final int DELETED = 4;
	
	private static final int DEFAULT_TOKEN_EXPIRY_MINUTES = 24*60;
	private static final long DEFAULT_PASSWORD_EXPIRY_WARN_TIME_BEFORE_EXPIRATION_IN_MILLISECONDS
		= 14*24*60*60*1000;
	
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="username")
    private String username;
    
    @Column(name="password")
    private String password;
    
    @Column(name="email_id")
    private String emailId;
    
    @Column(name="role")
    private String role;
    
	@Column(name="is_locked")
    private boolean isLocked;
    
    @Column(name="lock_expiration_time_in_min")
    private int lockExpirationTimeInMin;
    
    @Column(name="last_login_attempt_datetime")
    private Date lastLoginAttemptDateTime;
    
    @Column(name="max_count_for_lock")
    private int maxCountForLock;
    
    @Column(name="login_failed_count")
    private int loginFailedCount;
    
    @Column(name="status")
    private int status;
    
    @Column(name="reason_for_status")
    private String reasonForStatus;
    
    @Column(name="is_password_expired")
    private boolean isPasswordExpired;
    
    @Column(name="last_password_changed_date")
    private Date lastPasswordChangedDate;
    
    @Column(name="password_expire_days")
    private int passwordExpireDays;
    
    @Column(name="password_reset_flag")
    private boolean passwordResetFlag;
    
    @Column(name="random_token")
    private String randomToken;
    
    @Column(name="token_expire_date")
    private Date tokenExpireDate;
    
    @Column(name="max_concurrent_sessions")
    private int maxConcurrentSessions;
    
    private void resetLock(){
    	if(isLocked() || getLoginFailedCount() > 0){
	    	long currentTimeInMilliseconds = System.currentTimeMillis();
	    	long lastLoginAttemptTimeInMilliseconds = getLastLoginAttemptDateTime().getTime();
	    	long lockExpirationTimeInMilliseconds = ((long)getLockExpirationTimeInMin())*60*1000;
	    	
	    	if(currentTimeInMilliseconds - lastLoginAttemptTimeInMilliseconds > lockExpirationTimeInMilliseconds){
	    		setLocked(false);
	    		setLoginFailedCount(0);
	    	}
    	}
    }
    
    private void checkAndSetPasswordExpiry(){
    	long currentTimeInMilliseconds = System.currentTimeMillis();
    	long passwordChangedTimeInMilliseconds = System.currentTimeMillis();
    	Date lastPasswordChangedDate = getLastPasswordChangedDate();
    	if(lastPasswordChangedDate != null){
    		passwordChangedTimeInMilliseconds = lastPasswordChangedDate.getTime();
    	}
    	long passwordExpireTimeInMilliseconds = ((long)getPasswordExpireDays())*24*60*60*1000;
    	logger.debug("checkAndSetPasswordExpiry :: current: "+currentTimeInMilliseconds
    			+" ;; passwordChanged: "+passwordChangedTimeInMilliseconds
    			+" ;; passwordExpire: "+passwordExpireTimeInMilliseconds);
    	if(passwordChangedTimeInMilliseconds + passwordExpireTimeInMilliseconds <= currentTimeInMilliseconds){
    		setPasswordExpired(true);
    	}
    	/*
    	 * Default: 14 days before password is expiring, user shall be prompted to change password
    	 * Instead of default, get it from a column in 'user_logins'
    	 */
    	if(passwordChangedTimeInMilliseconds + passwordExpireTimeInMilliseconds <= 
    			(currentTimeInMilliseconds + 
    					DEFAULT_PASSWORD_EXPIRY_WARN_TIME_BEFORE_EXPIRATION_IN_MILLISECONDS)){
    		setPasswordResetFlag(true);
    	}
    }
    
    private void resetLoginAttempt(){
    	setLastLoginAttemptDateTime(Calendar.getInstance().getTime());
    }
    
    public void createRandomToken(Date tokenExpiryDate){
    	setRandomToken(RandomCreationUtil.createAlphaNumericString(30));
    	if(tokenExpiryDate == null){
    		Calendar calendar = Calendar.getInstance();
        	calendar.add(Calendar.MINUTE, DEFAULT_TOKEN_EXPIRY_MINUTES);
        	tokenExpiryDate = calendar.getTime();
    	}
    	setTokenExpireDate(tokenExpiryDate);
    }
    
    public void setOrUpdatePassword(String encodedPassword){
    	setOrUpdatePassword(encodedPassword, false);
    }
    
    public void setOrUpdatePassword(String encodedPassword, boolean expired) {
		setPassword(encodedPassword);
		if(!expired){
			setPasswordExpired(false);
			setLastPasswordChangedDate(Calendar.getInstance().getTime());
			setPasswordResetFlag(false);
			setRandomToken(null);
			setTokenExpireDate(null);
			if(isDisabled()){
				setEnabled(true);
				setReasonForStatus("Enabled after setting new password.");
			}
		}
	}
    
    public void checkAndResetPreliminaries(){
    	resetLock();
    	checkAndSetPasswordExpiry();
    	resetLoginAttempt();
    }
    
    public boolean isRandomTokenValid(){
    	long currentTimeInMilliseconds = System.currentTimeMillis();
    	long tokenExpiryTimeInMilliseconds = getTokenExpireDate().getTime();
    	boolean ret = (currentTimeInMilliseconds < tokenExpiryTimeInMilliseconds);
    	if(!ret){
    		clearRandomToken();
    	}
    	return ret;
    }
    
    public boolean clearRandomToken(){
    	setRandomToken("");
		setTokenExpireDate(null);
		return true;
    }
    
    public boolean clearPassword(){
    	setOrUpdatePassword("password-cleared", true);
    	return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public int getLockExpirationTimeInMin() {
        return lockExpirationTimeInMin;
    }

    public void setLockExpirationTimeInMin(int lockExpirationTimeInMin) {
        this.lockExpirationTimeInMin = lockExpirationTimeInMin;
    }

    public Date getLastLoginAttemptDateTime() {
        return lastLoginAttemptDateTime;
    }

    public void setLastLoginAttemptDateTime(Date lastLoginAttemptDateTime) {
        this.lastLoginAttemptDateTime = lastLoginAttemptDateTime;
    }

    public int getMaxCountForLock() {
        return maxCountForLock;
    }

    public void setMaxCountForLock(int maxCountForLock) {
        this.maxCountForLock = maxCountForLock;
    }

    public int getLoginFailedCount() {
        return loginFailedCount;
    }

    public void setLoginFailedCount(int loginFailedCount) {
        this.loginFailedCount = loginFailedCount;
    }

    public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isDisabled() {
        return (status == DISABLED);
    }

    public void setDisabled(boolean isDisabled) {
        if(isDisabled){
        	this.status = DISABLED;
        }
    }
    
    public boolean isExpired(){
    	return (status == EXPIRED);
    }
    
    public void setExpired(boolean isExpired){
    	if(isExpired){
    		status = EXPIRED;
    	}
    }
    
    public boolean isDeleted(){
    	return (status == DELETED);
    }
    
    public void setDeleted(boolean isDeleted){
    	if(isDeleted){
    		status = DELETED;
    	}
    }
    
    public boolean isEnabled(){
    	return (status == ENABLED);
    }
    
    public void setEnabled(boolean isEnabled){
    	if(isEnabled){
    		status = ENABLED;
    	}
    }

    public String getReasonForDisable() {
        return reasonForStatus;
    }

    public void setReasonForStatus(String reasonForStatus) {
        this.reasonForStatus = reasonForStatus;
    }

    public boolean isPasswordExpired() {
        return isPasswordExpired;
    }

    public void setPasswordExpired(boolean isPasswordExpired) {
        this.isPasswordExpired = isPasswordExpired;
    }

    public Date getLastPasswordChangedDate() {
        return lastPasswordChangedDate;
    }

    public void setLastPasswordChangedDate(Date lastPasswordChangedDate) {
        this.lastPasswordChangedDate = lastPasswordChangedDate;
    }

    public int getPasswordExpireDays() {
        return passwordExpireDays;
    }

    public void setPasswordExpireDays(int passwordExpireDays) {
        this.passwordExpireDays = passwordExpireDays;
    }

    public boolean isPasswordResetFlag() {
        return passwordResetFlag;
    }

    public void setPasswordResetFlag(boolean passwordResetFlag) {
        this.passwordResetFlag = passwordResetFlag;
    }

    public String getRandomToken() {
        return randomToken;
    }

    public void setRandomToken(String randomToken) {
        this.randomToken = randomToken;
    }

    public Date getTokenExpireDate() {
        return tokenExpireDate;
    }

    public void setTokenExpireDate(Date tokenExpireDate) {
        this.tokenExpireDate = tokenExpireDate;
    }

    public int getMaxConcurrentSessions() {
		return maxConcurrentSessions;
	}

	public void setMaxConcurrentSessions(int maxConcurrentSessions) {
		this.maxConcurrentSessions = maxConcurrentSessions;
	}

	public String getReasonForStatus() {
		return reasonForStatus;
	}

    @Override
    public String toString() {
        return "UserLogin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", emailId='" + emailId + '\'' +
                ", role=" + role +
                ", isLocked=" + isLocked +
                ", lockExpirationTimeInMin=" + lockExpirationTimeInMin +
                ", lastLoginAttemptDateTime=" + lastLoginAttemptDateTime +
                ", maxCountForLock=" + maxCountForLock +
                ", loginFailedCount=" + loginFailedCount +
                ", status=" + status +
                ", reasonForDisable='" + reasonForStatus + '\'' +
                ", isPasswordExpired=" + isPasswordExpired +
                ", lastPasswordChangedDate=" + lastPasswordChangedDate +
                ", passwordExpireDays=" + passwordExpireDays +
                ", passwordResetFlag=" + passwordResetFlag +
                ", randomToken='" + randomToken + '\'' +
                ", tokenExpireDate=" + tokenExpireDate +
                '}';
    }
}
