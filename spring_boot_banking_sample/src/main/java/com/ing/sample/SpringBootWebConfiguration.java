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
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.SAVING));
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.SAVING));
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.SAVING));
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.CREDIT_CARD));
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.CREDIT_CARD));
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.LOAN));
		userAccounts.getAllAccounts().add(getMockAccount(AccountTypeEnum.LOAN));
		return userAccounts;
	}
	
	private Account getMockAccount(AccountTypeEnum acctType) {
		Integer id = new Random().nextInt();
		id = id < 0 ? id * -1 : id;
		
		Account account = new Account();
		account.setAccountNumber("ING_" + id + "_" + acctType.name());
		account.setAccountStatus(AccountStatusEnum.ACTIVE);
		account.setAccountType(acctType);
		account.setBalance(15.4f);
		account.setBankName("International Nertherland Group");
		account.setHolderName("Gobinath Vengatasan");
		account.setId(id);
		return account;		
	}
}
