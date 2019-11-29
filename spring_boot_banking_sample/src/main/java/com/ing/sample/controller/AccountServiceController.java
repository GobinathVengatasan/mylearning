package com.ing.sample.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
	public List<Account> getAllAccounts() {		
		UserAccounts userAccounts = (UserAccounts) ApplicationContextProvider.getContext().getBean(UserAccounts.class);
		return userAccounts.getAllAccounts().stream().sorted(Comparator.comparing(Account::getBalance)).collect(Collectors.toList());
	}
	
	@GetMapping("/account/{accountId}")
	public Account getAccount(@PathVariable String accountId) {		
		UserAccounts userAccounts = (UserAccounts) ApplicationContextProvider.getContext().getBean(UserAccounts.class);		
		return userAccounts.getAllAccounts().stream().filter(it-> it.getId()==Integer.parseInt(accountId)).findFirst().orElse(null);
	}	

}