package com.wisdom.bean;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.wisdom.utility.json.JacksonUtil;

public class WisdomUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WisdomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
			String emailId, int maxConcurrentSessions) {
		this(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		setEmailId(emailId);
		setMaxConcurrentSessions(maxConcurrentSessions);
	}

	public WisdomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public WisdomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	private String emailId;
	private int maxConcurrentSessions;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getMaxConcurrentSessions() {
		return maxConcurrentSessions;
	}

	public void setMaxConcurrentSessions(int maxConcurrentSessions) {
		this.maxConcurrentSessions = maxConcurrentSessions;
	}
	
	@Override
	public String toString() {
		return JacksonUtil.toString(this);
	}

}
