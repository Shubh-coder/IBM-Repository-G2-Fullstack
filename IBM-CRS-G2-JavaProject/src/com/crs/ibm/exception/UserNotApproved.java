package com.crs.ibm.exception;

public class UserNotApproved extends Exception{
	public  UserNotApproved() {
		// TODO Auto-generated constructor stub

		super("You are not approved by the admin!!");
	}
	public  UserNotApproved(String message) {
		super(message);
	}

}
