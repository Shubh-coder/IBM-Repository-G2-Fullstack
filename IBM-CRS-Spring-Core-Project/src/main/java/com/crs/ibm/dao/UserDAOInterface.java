package com.crs.ibm.dao;

import com.crs.ibm.exception.UserNotExists;

public interface UserDAOInterface {
	public void passwordReviwer(String mail, String role) throws UserNotExists;
	/**
	 * Method for changing the user password
	 * @param mail id , user role
	 * @exception UserNotExists
	 */
	public void allUser();
	/**
	 * Method for showing all user whose approval is pending
	 * @param mail id , user role,password,approval
	 * @exception UserNotExists
	 */

	public void StudentDetail(String name,String quali,String branch,String contact,String address);
	/**
	 * Method for inserting all details of student
	 * @param name, qualification, branch, contact, address
	 * @exception UserNotExists
	 */
	public void userLoginTracker(String name, String role, String date) throws UserNotExists;


}
