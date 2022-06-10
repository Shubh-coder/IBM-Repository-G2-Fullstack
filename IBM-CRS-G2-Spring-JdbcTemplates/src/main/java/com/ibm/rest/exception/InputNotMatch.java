package com.ibm.rest.exception;

public class InputNotMatch extends Exception{


	public InputNotMatch() {
		super (" your are inserted wrong Input ");
	}
	public InputNotMatch(String message) {
		super (message);
	}


}
