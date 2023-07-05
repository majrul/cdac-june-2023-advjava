package com.cdac.component.banking;

import org.springframework.stereotype.Component;

@Component
public class CitiBank implements Bank {

	public void withdraw(int atmId, int acno, double amount) {
		System.out.println("customer of citibank trying to withdraw money..");
	}
}
