package com.wisdom.service.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.wisdom.entity.UserLogin;
import com.wisdom.bean.WisdomUser;

public class CustomUserDetailsService implements UserDetailsService{
	
	private static Logger logger = LogManager.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private UserManagementService userManagementService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLogin userLogin = userManagementService.findUserByUsername(username);
		if(userLogin != null){
			logger.debug("UserLogin: BEFORE PRELIM :: username:"+userLogin.getUsername()+" ;; passwordExpired: "+userLogin.isPasswordExpired());
			userLogin.checkAndResetPreliminaries();
			logger.debug("UserLogin: AFTER PRELIMINARY :: username:"+userLogin.getUsername()+" ;; passwordExpired: "+userLogin.isPasswordExpired());
			WisdomUser user = new WisdomUser(username, userLogin.getPassword(), userLogin.isEnabled()
					, !userLogin.isExpired(), !userLogin.isPasswordExpired(), !userLogin.isLocked()
					, getGrantedAuthorities(userLogin.getRole()), userLogin.getEmailId(), userLogin.getMaxConcurrentSessions());
			return user;
		}
		else{
			logger.debug("No username '"+username+"' found.");
			throw new UsernameNotFoundException("No username '"+username+"' found.");
		}
	}
	
	private Collection<? extends GrantedAuthority> getGrantedAuthorities(String role){
		Set<SimpleGrantedAuthority> ret = new HashSet<>();
		SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
		ret.add(grantedAuthority);
		return ret;
	}

}
