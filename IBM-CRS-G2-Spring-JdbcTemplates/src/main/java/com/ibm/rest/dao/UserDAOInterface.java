package com.ibm.rest.dao;

import java.util.List;

import com.ibm.rest.bean.*;
import com.ibm.rest.exception.AlreadyRegister;
import com.ibm.rest.exception.RegistrationException;
import com.ibm.rest.exception.UserNotApproved;
import com.ibm.rest.exception.UserNotExists;

public interface UserDAOInterface {

	public void Newregistration(String name, String
			email, String password, String role) throws AlreadyRegister;
	/**
	 * Method to register new user to the user table 
	 * @param name, email, password, role
	 * @throws UserNotApproved 
	 * @throws RegistrationException 
	 * @throws AlreadyRegister
	 */
	public List<Login> LoginUser(String email, String password) throws UserNotApproved,UserNotExists;
	/**
	 * Method for login by user
	 * 
	 * @param email, password
	 * 
	 * @throws UserNotExists
	 */
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



}
