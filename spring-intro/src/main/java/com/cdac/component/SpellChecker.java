package com.cdac.component;

import org.springframework.stereotype.Component;

@Component
public class SpellChecker {

	//String[] dict = {"Hello", "Hi", "Welcome"};
	
	public void checkSpellingMistakes(String document) {
		System.out.println("spell checker executed for " + document);
	}
}
