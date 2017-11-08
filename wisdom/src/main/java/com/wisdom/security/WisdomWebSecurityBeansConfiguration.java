package com.wisdom.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;
import org.springframework.security.web.session.InvalidSessionStrategy;

import com.wisdom.security.filter.AllRequestsAllowingCORSFilter;
import com.wisdom.security.filter.CORSFilter;
import com.wisdom.security.handler.CustomLogoutSuccessHandler;
import com.wisdom.security.strategy.CustomAuthenticationSuccessRedirectStrategy;
import com.wisdom.security.strategy.CustomInvalidSessionStrategy;
import com.wisdom.security.strategy.CustomLogoutSuccessStrategy;
import com.wisdom.service.CustomUserDetailsService;

@Configuration
public class WisdomWebSecurityBeansConfiguration {
	
	@Bean
	public CORSFilter corsFilter() {
		return new AllRequestsAllowingCORSFilter();
	}
	
	/*@Bean
	public CORSFilter corsFilter() {
		return new CORSFilter();
	}*/

	/*@Bean
	public InvalidSessionStrategy redirectStrategyInvalidSessionStrategy(){
		return new SimpleRedirectInvalidSessionStrategy("/user/login");
	}*/
	
	@Bean
	public InvalidSessionStrategy customInvalidSessionStrategy(){
		return new CustomInvalidSessionStrategy();
	}
	
	@Bean
	public RedirectStrategy customLogoutSuccessStrategy() {
		return new CustomLogoutSuccessStrategy();
	}
	
	@Bean
	public CustomLogoutSuccessHandler customLogoutSuccessHandler() {
		CustomLogoutSuccessHandler ret = new CustomLogoutSuccessHandler();
		ret.setRedirectStrategy(customLogoutSuccessStrategy());
		return ret;
	}
	
	@Bean
	public RedirectStrategy authenticationSuccessRedirectStrategy(){
		return new CustomAuthenticationSuccessRedirectStrategy();
	}
	
	@Bean
	public AuthenticationSuccessHandler redirectStrategyLoginSuccessHandler(){
		SavedRequestAwareAuthenticationSuccessHandler ret = 
				new SavedRequestAwareAuthenticationSuccessHandler();
		ret.setRedirectStrategy(authenticationSuccessRedirectStrategy());
		ret.setTargetUrlParameter("redirectUrl");
		return ret;
	}
	
	@Bean
	public SessionFixationProtectionStrategy sessionFixationProtectionStrategy(){
		SessionFixationProtectionStrategy ret = new SessionFixationProtectionStrategy();
		ret.setMigrateSessionAttributes(false);
		return ret;
	}
	
	@Bean
	public UserDetailsService userDetailsService(){
		return new CustomUserDetailsService();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationFailureHandler exceptionMappingAuthenticationFailureHandler(){
		ExceptionMappingAuthenticationFailureHandler ret
			= new ExceptionMappingAuthenticationFailureHandler();
		ret.setExceptionMappings(exceptionToUrlMap());
		ret.setDefaultFailureUrl("/error/defaultFailure");
		return ret;
	}
	
	private Map<String, String> exceptionToUrlMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put(CredentialsExpiredException.class.getName(), "/error/credentialsExpired");
		map.put(UsernameNotFoundException.class.getName(), "/error/usernameNotFound");
		map.put(BadCredentialsException.class.getName(), "/error/badCredentials");
		map.put(LockedException.class.getName(), "/error/lockedException");
		map.put(DisabledException.class.getName(), "/error/disabledException");
		return map;
	}

}
