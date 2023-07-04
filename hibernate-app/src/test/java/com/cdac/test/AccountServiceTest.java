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
		account.setBalance(5000);
		accountService.openAccount(account);
	}
	
	@Test
	public void testing_Withdraw() {
		AccountService accountService = new AccountService();
		accountService.withdraw(1, 1000);
	}

	@Test
	public void testing_Deposit() {
		AccountService accountService = new AccountService();
		accountService.deposit(1, 1000);
	}

	@Test
	public void testing_Transfer() {
		AccountService accountService = new AccountService();
		accountService.transfer(1, 2, 1000);
	}
}
