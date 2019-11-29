package com.ing.sample;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ing.sample.model.Account;
import com.ing.sample.model.AccountStatusEnum;
import com.ing.sample.model.AccountTypeEnum;
import com.ing.sample.model.UserAccounts;

@Configuration
public class SpringBootWebConfiguration {
	
	@Autowired
	UserAccounts userAccounts;

	@Bean	
	public UserAccounts getUserAccounts() {		
		return getMockUserAccounts();
	}
	
	private UserAccounts getMockUserAccounts() {
		UserAccounts userAccounts = new UserAccounts();
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.SAVING,15.4f));
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.SAVING,14.4f));
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.SAVING,13.4f));
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.CURRENT,1.4f));
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.CURRENT,16.4f));
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.CURRENT,12.4f));		
		return userAccounts;
	}
	
	private Account getMockAccount(AccountTypeEnum acctType,float balance) {
		Integer id = new Random().nextInt();
		id = id < 0 ? id * -1 : id;
		
		Account account = new Account();
		account.setAccountNumber("ING_" + id + "_" + acctType.name());
		account.setAccountStatus(AccountStatusEnum.ACTIVE);
		account.setAccountType(acctType);
		account.setBalance(balance);
		account.setBankName("International Nertherland Group");
		account.setHolderName("Gobinath Vengatasan");
		account.setId(id);
		return account;		
	}
}
