package com.cdac.component;

import org.springframework.stereotype.Component;

@Component("calc") //this is equivalent to: <bean id="calc" class="com.cdac.component.Calculator" />
public class Calculator {

	public int add(int x, int y) {
		return x + y;
	}

	public int sub(int x, int y) {
		return x - y;
	}
}
