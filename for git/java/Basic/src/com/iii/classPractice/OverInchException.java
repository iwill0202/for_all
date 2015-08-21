package com.iii.classPractice;

public class OverInchException extends Exception {
	private static final long serialVersionUID = 1L;
	private String reason;
	public OverInchException(String reason){
		this.reason = reason;
	}
	public String getReason(){
		return reason;
	}
	/*public int getinch(){
		return inch;
	}*/
}
