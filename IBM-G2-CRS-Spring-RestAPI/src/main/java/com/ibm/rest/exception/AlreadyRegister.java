/**
 * 
 */
package com.ibm.rest.exception;

import java.sql.SQLException;

/**
 * @author 003NRH744
 *
 */
public class AlreadyRegister extends Exception {
	public AlreadyRegister() {
		super ("your email ID or username already enrolled!!, Please use different one ");
	}
	public AlreadyRegister(String message) {
		super (message);
	}

}
