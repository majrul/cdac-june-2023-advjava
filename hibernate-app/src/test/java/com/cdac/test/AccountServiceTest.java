package com.cdac.test;

import org.junit.Test;

import com.cdac.entity.Account;
import com.cdac.service.AccountService;

public class AccountServiceTest {

	@Test
	public void testing_openAccount() {
		AccountService accountService = new AccountService();
		
		Account account = new Account();
		account.setName("Smith");
		account.setType("Savings");
		account.setBalance(4000);
		accountService.openAccount(account);
	}
}
