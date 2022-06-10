/**
 * 
 */
package com.ibm.rest.exception;

import java.sql.SQLException;

/**
 * @author 003NRH744
 *
 */
public class RegistrationException extends Exception{
	public RegistrationException() {
		// TODO Auto-generated constructor stub
		super("If you are a new user please Login!!!");

	}
	public RegistrationException(String message){
		super(message);
	}

}
