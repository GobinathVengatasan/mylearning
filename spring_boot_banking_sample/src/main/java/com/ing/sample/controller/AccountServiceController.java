package com.ing.sample.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.sample.ApplicationContextProvider;
import com.ing.sample.helper.AccountServiceHelper;
import com.ing.sample.model.Account;
import com.ing.sample.model.AccountStatusEnum;
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

	@PostMapping("/account")
	public String createAccount(@RequestBody Account account) {		
		AccountServiceHelper.jsonLogger(account);
		UserAccounts userAccounts = (UserAccounts) ApplicationContextProvider.getContext().getBean(UserAccounts.class);
		userAccounts.getAllAccounts().add(account);
		return "SUCCESS";
	}
	
	@DeleteMapping("/account/{accountId}")
	public ResponseEntity<String> deleteAccount(@PathVariable String accountId) {
		
		UserAccounts userAccounts = (UserAccounts) ApplicationContextProvider.getContext().getBean(UserAccounts.class);
		Optional<Account> accountResult = userAccounts.getAllAccounts().stream().filter(it-> it.getId()==Integer.parseInt(accountId)).findAny();
		
		if(accountResult.isPresent()) {
			Account account = accountResult.get();
			if(account.getAccountStatus() == AccountStatusEnum.IN_ACTIVE)
				userAccounts.getAllAccounts().remove(account);
			else return new ResponseEntity<String>("Acvive or Closed account cannot be deleted!",HttpStatus.ACCEPTED);
		}
		else return new ResponseEntity<String>("Account Not Found!",HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
}