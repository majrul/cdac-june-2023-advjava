package com.cdac.component;

import org.springframework.stereotype.Component;

@Component("engine")
public class Engine {

	public void run() {
		System.out.println("vroom vroom..");
	}
}
