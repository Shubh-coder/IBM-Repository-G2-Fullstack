/**
 * 
 */
package com.crs.ibm.exception;

import java.sql.SQLException;

/**
 * @author 003NRH744
 *
 */
public class SeatNotAvailable  extends Exception {
	public SeatNotAvailable () {
		// TODO Auto-generated constructor stub
		super("SORRY, Seats are filled!!! ");

	}
	public SeatNotAvailable (String message){
		super(message);
	}
}
