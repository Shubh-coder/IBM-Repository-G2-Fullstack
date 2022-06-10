/**
 * 
 */
package com.crs.ibm.exception;

import com.crs.ibm.bean.Course;

/**
 * @author 003NRH744
 *
 */
public class CourseNotAdded extends Exception {
	public  CourseNotAdded() {
		super("Your Course was not added!");
	}
	public CourseNotAdded(String message) {
		super(message);
	}
}
