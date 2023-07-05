package com.cdac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cdac.component.Greeting;
import com.cdac.component.HelloWorld;

//This class will be replacement for the xml file
@Configuration
@ComponentScan("com.cdac.component")
public class MySpringConfig {

	@Bean
	public HelloWorld hello() {
		return new HelloWorld();
	}
	
	@Bean
	public Greeting greet() {
		return new Greeting();
	}
	
}
