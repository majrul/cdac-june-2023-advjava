package com.cdac.component;

import org.springframework.stereotype.Component;

@Component("currencyConv")
public class CurrencyConverter {

	public double convert(String from, String to, double amount) {
		if(from.equals("USD") && to.equals("INR"))
			return amount * 82.75;
		else if(from.equals("GBP") && to.equals("INR"))
			return amount * 102.75;
		else
			return 0; //instead we should throw exception
	}
}
