package com.cdac.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextEditor {

	@Autowired
	private SpellChecker sp;
	
	/*
	 * Whenever the text editor loads any document in the memory,
	 * it should then go and check if there are any spelling mistakes in the same
	 */
	public void load(String document) {
		System.out.println("text editor loaded " + document);
		//SpellChecker sp = new SpellChecker();
		sp.checkSpellingMistakes(document);
	}
}
