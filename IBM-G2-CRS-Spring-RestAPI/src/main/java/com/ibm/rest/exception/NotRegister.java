package com.ibm.rest.exception;

public class NotRegister extends Exception {

	public NotRegister(){
		super("You have not Redisterd for any course.");
	}
	public NotRegister(String message) {
		super(message);
	}

}
