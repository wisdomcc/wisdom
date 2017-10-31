package com.wisdom.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;

import com.wisdom.security.filter.CORSFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WisdomWebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SessionAuthenticationStrategy sessionAuthenticationStrategy;
	
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;
	
	@Autowired
	private CORSFilter corsFilter;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.httpBasic().disable()
		//.and()
		.authorizeRequests()
		.antMatchers("/user/login","/user/registration").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/user/login")
			.usernameParameter("username").passwordParameter("password")
			.failureHandler(authenticationFailureHandler)
			.successHandler(authenticationSuccessHandler)
		.and()
		.sessionManagement().sessionAuthenticationStrategy(sessionAuthenticationStrategy)
			//.invalidSessionStrategy(invalidSessionStrategy)
		.and()
		.addFilterBefore(corsFilter, WebAsyncManagerIntegrationFilter.class)
		.csrf().disable();
	}
	
	public void configureAuthenticationBuilder(AuthenticationManagerBuilder authenticationManagerBuilder)
		throws Exception{
			authenticationManagerBuilder.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder);
	}
}
