/**
 * 
 */
package com.crs.ibm.exception;

import java.sql.SQLException;

/**
 * @author 003NRH744
 *
 */
public class NotRemoved extends Exception{
	public NotRemoved() {
		super("Course was not removed, enter correct course ID");
	}
	public NotRemoved(String message) {
		super(message);
	}

}
