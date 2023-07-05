package com.cdac.component.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HdfcAtm implements Atm {

	@Autowired
	private Bank bank;
	
	public void withdraw(int acno, double amount) {
		System.out.println("customer at hdfcatm trying to withdraw money..");
		bank.withdraw(1234, acno, amount);
	}

}
