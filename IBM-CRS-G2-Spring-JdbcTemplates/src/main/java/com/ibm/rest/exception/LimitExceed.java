/**
 * 
 */
package com.ibm.rest.exception;

import java.sql.SQLException;

/**
 * @author 003NRH744
 *
 */
public class LimitExceed extends SQLException {
	public LimitExceed() {
		super ("Sorry, Limit of the course exceed!!, try some other courses ");
	}
	public LimitExceed(String message) {
		super (message);
	}

}
