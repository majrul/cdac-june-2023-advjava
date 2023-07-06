package com.cdac.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.Calculator;
import com.cdac.component.Car;
import com.cdac.component.CurrencyConverter;
import com.cdac.component.Greeting;
import com.cdac.component.HelloWorld;
import com.cdac.component.LoginService;
import com.cdac.component.TextEditor;
import com.cdac.component.banking.Atm;
import com.cdac.component.banking.HdfcAtm;

public class App {
	
	public static void main(String[] args) {
		//Load the IoC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(MySpringConfig.class);
		//Accessing a bean
		//why are we using Spring? why not we write like this:
		//HelloWorld hw = new HelloWorld();
		for(int i=0; i<5; i++) {
			HelloWorld hw = (HelloWorld) ctx.getBean("hello");
			System.out.println(hw.sayHello("Majrul"));
		}
		
		/*Greeting gt = (Greeting) ctx.getBean("greet");
		System.out.println(gt.greet("Majrul"));
		
		Calculator calc = (Calculator) ctx.getBean("calc");
		System.out.println(calc.add(10, 20));
		
		LoginService loginService = (LoginService) ctx.getBean("login");
		if(loginService.isValidUser("majrul", "123"))
			System.out.println("Congrats, you have successfully logged in!");
		else
			System.out.println();
		
		CurrencyConverter cc = (CurrencyConverter) ctx.getBean("currencyConv");
		System.out.println(cc.convert("USD", "INR", 100));
		
		Car car = (Car) ctx.getBean("car");
		car.start();
		
		//TextEditor te = (TextEditor) ctx.getBean("textEditor");
		TextEditor te = ctx.getBean(TextEditor.class);
		te.load("abc.txt");
		
		Atm atm = ctx.getBean(HdfcAtm.class);
		atm.withdraw(101010, 5000);*/
	}
}
