package com.ing.sample.iterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ing.sample.ApplicationContextProvider;
import com.ing.sample.model.UserAccounts;
import com.ing.sample.service.StubServiceProvider;

public class AccountServiceInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		System.out.println("Invoking AccountServiceInterceptor preHandle");
		UserAccounts userAccounts = (UserAccounts) ApplicationContextProvider.getContext().getBean(UserAccounts.class);
		if(userAccounts.getAllAccounts().isEmpty()) {
			System.out.println("Stubbing the accounts data as Hard Coded!");
			StubServiceProvider.populateUserAccounts(userAccounts);			
		}
		
		return true;
	}

}
