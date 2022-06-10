package com.crs.ibm.service;

import java.util.*;

import com.crs.ibm.bean.Student;
import com.crs.ibm.dao.ProfessorDAO;
import com.crs.ibm.dao.ProfessorDAOInterface;
import com.crs.ibm.exception.GradeNotAssigned;
import com.crs.ibm.exception.NoDataFound;
import com.crs.ibm.exception.UserNotExists;

public class ProfessorService implements ProfessorInterface {
	ProfessorDAOInterface pdo= new ProfessorDAO();

	/**
	 * Method to fetch the student detail from the student table. 
	 * @param name, email, password, role
	 * @throw NoDataFound
	 */
	public void getEnrolledStudent() throws NoDataFound {
		// TODO Auto-generated method stub
		try {
			pdo.getEnrolledStudent();
		}catch(NoDataFound e) {
			throw e;
		}

	}

	/**
	 * Method for the professor to add grades to the students
	 * @param student_id and a grade
	 * @throws GradeNotAssigned, UserNotExists
	 */
	public void addGrade(int sid, String gd) throws GradeNotAssigned, UserNotExists {
		// TODO Auto-generated method stub
		try {
			pdo.addGrade(sid, gd);
		}catch(GradeNotAssigned | UserNotExists e) {
			throw e;
		}

	}





}
