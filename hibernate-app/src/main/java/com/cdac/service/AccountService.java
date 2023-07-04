package com.cdac.service;

import java.time.LocalDateTime;
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
		//balance should get updated in the account table
		//one record should get inserted in transaction table
		GenericDao dao = new GenericDao();
		Account account = (Account) dao.findByPK(Account.class, acno);
		if(amount > account.getBalance())
			throw new AccountException("Cannot Withdraw. Insufficient Balance!");
		else {
			account.setBalance(account.getBalance() - amount);
			dao.save(account);
			Transaction tx = new Transaction();
			tx.setType("WITHDRAW");
			tx.setAmount(amount);
			tx.setDateAndTime(LocalDateTime.now());
			tx.setAccount(account);
			dao.save(tx);
		}
	}

	public void deposit(int acno, double amount) {
		GenericDao dao = new GenericDao();
		Account account = (Account) dao.findByPK(Account.class, acno);
		account.setBalance(account.getBalance() + amount);
		dao.save(account);
		Transaction tx = new Transaction();
		tx.setType("DEPOSIT");
		tx.setAmount(amount);
		tx.setDateAndTime(LocalDateTime.now());
		tx.setAccount(account);
		dao.save(tx);
	}

	public void transfer(int fromAcno, int toAcno, double amount) {
		//withdraw(fromAcno,  amount);
		//deposit(toAcno, amount);
		GenericDao dao = new GenericDao();
		Account fromAccount = (Account) dao.findByPK(Account.class, fromAcno);
		Account toAccount = (Account) dao.findByPK(Account.class, toAcno);
		if(amount > fromAccount.getBalance())
			throw new AccountException("Cannot Transfer. Insufficient Balance!");
		else {
			fromAccount.setBalance(fromAccount.getBalance() - amount);
			toAccount.setBalance(toAccount.getBalance() + amount);

			Transaction tx1 = new Transaction();
			tx1.setType("FUND TRANSFER");
			tx1.setAmount(amount);
			tx1.setDateAndTime(LocalDateTime.now());
			tx1.setAccount(fromAccount);
			Transaction tx2 = new Transaction();
			tx2.setType("FUND RECEIVED");
			tx2.setAmount(amount);
			tx2.setDateAndTime(LocalDateTime.now());
			tx2.setAccount(toAccount);
			
			dao.save(fromAccount);
			dao.save(toAccount);
			dao.save(tx1);
			dao.save(tx2);
		}
	}
	
	public double balanceCheck(int acno) {
		return 0;
	}
	
	public List<Transaction> miniStatement(int acno) {
		//write the query in the dao to fetch recent 5 transactions done in the given account
		return null;
	}
}
