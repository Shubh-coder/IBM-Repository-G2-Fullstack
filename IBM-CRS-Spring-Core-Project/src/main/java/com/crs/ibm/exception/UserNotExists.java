/**
 * 
 */
package com.crs.ibm.exception;

import java.sql.SQLException;

/**
 * @author 003NRH744
 *
 */
public class UserNotExists extends Exception {
	public UserNotExists() {
		super("Sorry we can't find you, rather you are not registered or your Approval is pending!!");
	}
	public UserNotExists(String message) {
		super(message);
	}
	public String UserNotFoundError() {
		return ("User not found please register");
	}

}
