package com.ibm.rest.exception;

public class ProfessorNotAssigned extends Exception {
	public ProfessorNotAssigned() {
		super("professor not assigned Yet!!");
	}
	public ProfessorNotAssigned(String msg) {
		super(msg);
	}

}
