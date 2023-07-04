package com.cdac.service;

import java.util.List;

import com.cdac.dao.GenericDao;
import com.cdac.entity.Account;
import com.cdac.entity.Transaction;
import com.cdac.exception.AccountException;

public class AccountService {

	public void openAccount(Account account) {
		if(account.getBalance() < 5000)
			throw new AccountException("Cannot open Account. Minimum Balance required is 5000 Rs!");
		else {
			GenericDao dao = new GenericDao();
			dao.save(account);
			//sending a welcome email to the customer
		}
	}
	
	public void withdraw(int acno, double amount) {
		one record should get inserted in transaction table
		balance should get updated in the account table
	}

	public void deposit(int acno, double amount) {
		
	}

	public void transfer(int fromAcno, int toAcno, double amount) {
		
	}
	
	public double balanceCheck(int acno) {
		return 0;
	}
	
	public List<Transaction> miniStatement(int acno) {
		return null;
	}
}
