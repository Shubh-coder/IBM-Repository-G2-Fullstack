package com.ibm.rest.DAO;

import java.util.List;

import com.ibm.rest.bean.User;
import com.ibm.rest.exception.UserNotExists;

public interface UserDAOInterface {
	public void passwordChange(String mail, String role) throws UserNotExists;
	/**
	 * Method for changing the user password
	 * @param mail id , user role
	 * @exception UserNotExists
	 */
	public List<User> allUser();
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
