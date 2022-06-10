/**
 * 
 */
package com.crs.ibm.exception;

/**
 * @author 003NRH744
 *
 */
public class NoDataFound extends  Exception {
	public NoDataFound() {
		super("Their is no data to fetch!");

	}
	public NoDataFound(String message) {
		super(message);
	}
}
