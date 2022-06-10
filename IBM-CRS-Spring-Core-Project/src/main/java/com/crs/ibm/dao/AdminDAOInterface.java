package com.crs.ibm.dao;

import java.util.List;

import com.crs.ibm.bean.Course;
import com.crs.ibm.exception.AlreadyRegister;
import com.crs.ibm.exception.CourseNotAdded;
import com.crs.ibm.exception.NoDataFound;
import com.crs.ibm.exception.NotRemoved;
import com.crs.ibm.exception.ProfessorNotAssigned;
import com.crs.ibm.exception.RegistrationException;
import com.crs.ibm.exception.UserNotApproved;
import com.crs.ibm.exception.UserNotExists;

public interface AdminDAOInterface {
	
	public void approveStudent(String email);
	/**
	 * Method to add courses to the course table 
	 * @param email ..
	 * @throws NotApproved
	 */
	
	
	public void  addCourse(int csid,String csname,String cssec,String cstype,int csmax,double csprice,int csdur, int csprid) throws CourseNotAdded;
	/**
	 * Method to add courses to the course table 
	 * @param course_id, Course_type, course_limit etc..
	 * @throws NotRemoved 
	 * @throws CourseNotAdded
	 */
	public void deleteCourse(int deid) throws NotRemoved;
	/**
	 * Method to remove courses from the course table 
	 * @param course_id
	 * @throws AlreadyRegister 
	 * @throws NotRemoved
	 */
	public void registrationApproval(String name, String
			email, String password, String role) throws AlreadyRegister;
	/**
	 * Method to register new user to the user table 
	 * @param name, email, password, role
	 * @throws UserNotApproved 
	 * @throws RegistrationException 
	 * @throws AlreadyRegister
	 */
	public void authenticateUser(String name, String password) throws UserNotApproved, UserNotApproved;
	/**
	 * Method to authenticate the user 
	 * @param  email, password
	 * @throws UserNotExists
	 */
	public void assignProfessor ()throws ProfessorNotAssigned;
		/**
		 * Method to assign a professor for a course
		 * @param professor_id and course_id
		 * @exception ProfessorNotAssigned
		 */
	public List<Course> allCourse() throws NoDataFound;
		/**
		 * Method to fetch all the course from course table
		 * @exception NoDataFound
		 */
	   /**
	    * Method to display current date and time
	    * @param localDate
	    */
	public  String displayCurrentDate();

   
}
