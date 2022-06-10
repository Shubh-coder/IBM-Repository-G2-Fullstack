/**
 * 
 */
package com.ibm.rest.DAO;

import java.util.List;

import com.ibm.rest.*;
import com.ibm.rest.bean.Student;
import com.ibm.rest.exception.GradeNotAssigned;
import com.ibm.rest.exception.NoDataFound;
import com.ibm.rest.exception.UserNotExists;

/**
 * @author 003NRH744
 *
 */
public interface ProfessorInterface {
	public List<Student> getEnrolledStudent() throws NoDataFound;
	/**
	 * Method to fetch the student detail from the student table. 
	 * @param name, email, password, role
	 * @throw UserNotExists
	 */
	public void addGrade(int studentid, String grade) throws GradeNotAssigned, UserNotExists; 
	/**
	 * Method for the professor to add grades to the students
	 * @param student_id and a grade
	 */


}
