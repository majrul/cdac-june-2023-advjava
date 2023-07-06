package com.cdac.component;

public class HelloWorld {

	public HelloWorld()  {
		System.out.println("HelloWorld() constructor called..");
	}
	
	public String sayHello(String name) {
		return "Hello " + name;
	}
}
