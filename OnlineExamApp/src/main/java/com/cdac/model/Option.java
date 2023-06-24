package com.cdac.model;

public class Option {

	private String option;
	private boolean isRightAnswer;
	
	public Option() {
		
	}
	public Option(String option, boolean isRightAnswer) {
		this.option = option;
		this.isRightAnswer = isRightAnswer;
	}
	
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public boolean isRightAnswer() {
		return isRightAnswer;
	}
	public void setRightAnswer(boolean isRightAnswer) {
		this.isRightAnswer = isRightAnswer;
	}
	
	
}
