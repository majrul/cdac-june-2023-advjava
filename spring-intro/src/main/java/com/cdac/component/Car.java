package com.cdac.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("car")
public class Car {

	@Autowired //DI
	private Engine engine;
	
	public void start() {
		//Engine engine = new Engine();
		engine.run();
	}
}
