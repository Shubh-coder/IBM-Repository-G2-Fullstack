package com.crs.ibm.dao;
import java.util.*;
import com.crs.ibm.bean.*;
import com.crs.ibm.bean.*;
import com.crs.ibm.exception.CourseNotAdded;
import com.crs.ibm.exception.GradeNotAssigned;
import com.crs.ibm.exception.NoDataFound;
import com.crs.ibm.exception.UserNotExists;


public interface ProfessorDAOInterface {

	public List<Student> getEnrolledStudent() throws NoDataFound;
	/**
	 * Method to fetch the student detail from the student table. 
	 * @param name, email, password, role
	 * @throw UserNotExists
	 */
	public void addGrade(int sid, String gd) throws GradeNotAssigned, UserNotExists; 
	/**
	 * Method for the professor to add grades to the students
	 * @param student_id and a grade
	 */

}
