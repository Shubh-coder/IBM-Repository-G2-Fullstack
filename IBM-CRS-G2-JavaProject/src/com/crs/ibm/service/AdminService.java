package com.crs.ibm.service;

import java.util.*;

import com.crs.ibm.dao.AdminDAO;
import com.crs.ibm.dao.AdminDAOInterface;
import com.crs.ibm.dao.UserDAO;
import com.crs.ibm.dao.UserDAOInterface;
import com.crs.ibm.exception.AlreadyRegister;
import com.crs.ibm.exception.CourseNotAdded;
import com.crs.ibm.exception.NoDataFound;
import com.crs.ibm.exception.NotRemoved;
import com.crs.ibm.exception.ProfessorNotAssigned;
import com.crs.ibm.exception.RegistrationException;
import com.crs.ibm.exception.UserNotApproved;
import com.crs.ibm.exception.UserNotExists;


public class AdminService implements AdminInterface{
	AdminDAOInterface addo= new AdminDAO();
	UserDAOInterface usdo = new UserDAO();
	/**
	 * Method to register new user to the user table 
	 * @param name, email, password, role
	 * @throws RegistrationException 
	 * @throws AlreadyRegister
	 */
	
	public void registrationApproval(String name, String email, String password, String role) throws AlreadyRegister{
		try {
			addo.registrationApproval(name, email, password, role);
		}catch(AlreadyRegister e){
			throw e;
		}
	}
	/**
	 * Method to authenticate the user 
	 * @param  email, password
	 * @throws UserNotExists
	 */
	public void authenticateUser(String name, String password) throws UserNotApproved{
		try {
			addo.authenticateUser(name, password);
		}catch(UserNotApproved e) {
			throw e;
		}
	}
	/**
	 * Method to add courses to the course table 
	 * @param course_id, Course_type, course_limit etc..
	 * @throws NotRemoved 
	 * @throws CourseNotAdded
	 */
	public void  addCourse(int csid,String csname,String cssec,String cstype,int csmax,double csprice,int csdur,int csprid) throws CourseNotAdded{
		try {
			addo.addCourse(csid, csname, cssec, cstype, csmax, csprice, csdur, csprid);;
		}catch(CourseNotAdded e) {
			throw e;
		}
	}
	/**
	 * Method to remove courses from the course table 
	 * @param course_id
	 * @throws AlreadyRegister 
	 * @throws NotRemoved
	 */
	public void deleteCourse(int deid) throws NotRemoved{
		try {
			addo.deleteCourse(deid);
		}catch(NotRemoved e) {
			throw e;
		}
	}
	/**
	 * Method for changing the user password
	 * @param mail id , user role
	 * @exception UserNotExists
	 */
	public void passwordReviewer(String email1, String role)  throws UserNotExists{

		// TODO Auto-generated method stub
		try {
			usdo.passwordReviwer( email1, role);
		}catch(UserNotExists e) {
			throw e;
		}

	}
	/**
	 * Method to assign a professor for a course
	 * @param professor_id and course_id
	 * @exception ProfessorNotAssigned
	 */
	public void assignProfessorFOrCourse() throws ProfessorNotAssigned{
		try {
			addo.assignProfessor();
		}catch(ProfessorNotAssigned e) {
			throw e;
		}
	}
	/**
	 * Method to fetch all the course from course table
	 * @exception NoDataFound
	 */
	public void showAllCourses() throws NoDataFound{
		try {
			addo.allCourse();
		}catch(NoDataFound e) {
			throw e;
		}
	}


}
