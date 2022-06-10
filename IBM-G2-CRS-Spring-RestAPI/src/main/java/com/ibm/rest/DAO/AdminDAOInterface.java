package com.ibm.rest.DAO;

import java.util.List;

import com.ibm.rest.bean.Course;
import com.ibm.rest.exception.AlreadyRegister;
import com.ibm.rest.exception.CourseNotAdded;
import com.ibm.rest.exception.NoDataFound;
import com.ibm.rest.exception.NotRegister;
import com.ibm.rest.exception.NotRemoved;
import com.ibm.rest.exception.ProfessorNotAssigned;
import com.ibm.rest.exception.RegistrationException;
import com.ibm.rest.exception.UserNotApproved;
import com.ibm.rest.exception.UserNotExists;

public interface AdminDAOInterface {
	
	public void approveStudent(String email);
	/**
	 * Method to add courses to the course table 
	 * @param email ..
	 * @return 
	 * @throws NotApproved
	 */
	
	
	public void  addCourse(int courseid,String coursename,String coursesection,String coursetype,int coursemax,double courseprice,int courseduration, int professorid) throws CourseNotAdded;
	/**
	 * Method to add courses to the course table 
	 * @param course_id, Course_type, course_limit etc..
	 * @throws NotRemoved 
	 * @throws CourseNotAdded
	 */
	public void deleteCourse(int courseid) throws NotRemoved;
	/**
	 * Method to remove courses from the course table 
	 * @param course_id
	 * @throws AlreadyRegister 
	 * @throws NotRemoved
	 */
	public void Newregistration(String name, String
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
	public void assignProfessor (int courseid,int professorid)throws ProfessorNotAssigned;
		/**
		 * Method to assign a professor for a course
		 * @param professor_id and course_id
		 * @exception ProfessorNotAssigned
		 */
	 
		 
	   /**
	    * Method to display current date and time
	    * @param localDate
	    */
	public  String displayCurrentDate();
	/**
	 * Method to fetch all the course from course table
	 * @exception NoDataFound
	 */
	public List<Course>AllCourses() throws NotRegister;

   
}
