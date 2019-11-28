package com.ing.sample.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.sample.model.Account;
import com.ing.sample.model.AccountStatusEnum;
import com.ing.sample.model.AccountTypeEnum;
import com.ing.sample.model.UserAccounts;

@RestController
@RequestMapping("/bank")
public class AccountServiceController {

	@GetMapping("/account")
	public UserAccounts getAllAccounts() {		
		return getMockUserAccounts();
	}
	
	@GetMapping("/account/{accountId}")
	public Account getAccount(@PathVariable String accountId) {		
		return getMockUserAccounts().getAllAccounts().stream().filter(it-> it.getId()==Integer.parseInt(accountId)).findFirst().orElse(null);
	}
		
	private UserAccounts getMockUserAccounts() {
		UserAccounts userAccounts = new UserAccounts();
		userAccounts.getAllAccounts().add(getMockAccount());
		return userAccounts;
	}

	private Account getMockAccount() {
		Account account = new Account();
		account.setAccountNumber("123Saving456");
		account.setAccountStatus(AccountStatusEnum.ACTIVE);
		account.setAccountType(AccountTypeEnum.SAVING);
		account.setBalance(15.4f);
		account.setBankName("International Nertherland Group");
		account.setHolderName("Gobinath Vengatasan");
		account.setId(1);
		return account;		
	}

}
