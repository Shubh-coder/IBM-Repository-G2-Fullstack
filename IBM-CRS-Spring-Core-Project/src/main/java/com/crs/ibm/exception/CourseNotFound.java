/**
 * 
 */
package com.crs.ibm.exception;

import java.sql.SQLException;

/**
 * @author 003NRH744
 *
 */
public class CourseNotFound extends Exception{
	public CourseNotFound() {
		super("the course your are looking is not found!!!");
	}
	public CourseNotFound(String message) {
		super(message);
	}

}
