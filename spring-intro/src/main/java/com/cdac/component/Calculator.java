package com.cdac.component;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("calc") //this is equivalent to: <bean id="calc" class="com.cdac.component.Calculator" />
@Scope("singleton")
@Lazy
public class Calculator {

	public Calculator() {
		System.out.println("Calculator() constructor called..");
	}
	
	public int add(int x, int y) {
		return x + y;
	}

	public int sub(int x, int y) {
		return x - y;
	}
}
