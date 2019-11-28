package com.ing.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.sample.ApplicationContextProvider;
import com.ing.sample.model.Account;
import com.ing.sample.model.UserAccounts;

@RestController
@RequestMapping("/bank")
public class AccountServiceController {

	@GetMapping("/account")
	public UserAccounts getAllAccounts() {
		
		UserAccounts userAccounts = (UserAccounts) ApplicationContextProvider.getContext().getBean(UserAccounts.class);
		return userAccounts;
	}
	
	@GetMapping("/account/{accountId}")
	public Account getAccount(@PathVariable String accountId) {		
		UserAccounts userAccounts = (UserAccounts) ApplicationContextProvider.getContext().getBean(UserAccounts.class);		
		return userAccounts.getAllAccounts().stream().filter(it-> it.getId()==Integer.parseInt(accountId)).findFirst().orElse(null);
	}	

}