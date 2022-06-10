package com.crs.ibm.service;

import com.crs.ibm.exception.CourseNotAdded;

public interface UserInterface {

	/**
	 * Method for login User 
	 * */
	public void  login();
	/**
	 * Method for Student Menu 
	 * */
	public void StudentMenu();
	/**
	 * Method for Professor Menu 
	 * */
	public void ProfessorMenu();
	/**
	 * Method for fetching role of User
	 * */
	public void UserSelection(String user);


}
