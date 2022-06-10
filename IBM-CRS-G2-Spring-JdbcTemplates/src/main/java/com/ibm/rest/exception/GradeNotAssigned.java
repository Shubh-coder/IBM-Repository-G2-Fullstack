package com.ibm.rest.exception;

public class GradeNotAssigned extends Exception{
	public GradeNotAssigned() {
		super("the course your are looking is not found!!!");
	}
	public GradeNotAssigned(String message) {
		super(message);
	}

}
