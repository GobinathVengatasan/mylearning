package com.ing.sample.service;

import java.util.Random;

import com.ing.sample.model.Account;
import com.ing.sample.model.AccountStatusEnum;
import com.ing.sample.model.AccountTypeEnum;
import com.ing.sample.model.UserAccounts;

public class StubServiceProvider {

	public static void populateUserAccounts(UserAccounts userAccounts) {		 
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.SAVING,15.4f));
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.SAVING,14.4f));
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.SAVING,13.4f,AccountStatusEnum.IN_ACTIVE));
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.CURRENT,1.4f));
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.CURRENT,16.4f,AccountStatusEnum.CLOSED));
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.CURRENT,12.4f));
	}
	
	private static Account getMockAccount(AccountTypeEnum acctType,float balance, AccountStatusEnum status) {
		Integer id = new Random().nextInt();
		id = id < 0 ? id * -1 : id;
		
		Account account = new Account();
		account.setAccountNumber("ING_" + id + "_" + acctType.name());
		account.setAccountStatus(status);
		account.setAccountType(acctType);
		account.setBalance(balance);
		account.setBankName("International Nertherland Group");
		account.setHolderName("Gobinath Vengatasan");
		account.setId(id);
		return account;
	}
	
	private static Account getMockAccount(AccountTypeEnum acctType,float balance) {
		return getMockAccount(acctType,balance,AccountStatusEnum.ACTIVE);
	}
}
