package com.ing.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ing.sample.iterceptor.AccountServiceInterceptor;
import com.ing.sample.model.UserAccounts;

@Configuration
public class SpringBootWebConfiguration extends WebMvcConfigurerAdapter {
	
	@Autowired
	UserAccounts userAccounts;
	
	@Autowired
	AccountServiceInterceptor accountServiceInterceptor;

	@Bean	
	public UserAccounts getUserAccounts() {		
		return new UserAccounts();
	}
	
	@Bean	
	public AccountServiceInterceptor getAccountServiceInterceptor() {		
		return new AccountServiceInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {		
		registry.addInterceptor(accountServiceInterceptor).addPathPatterns("/bank/*");
	}
}
