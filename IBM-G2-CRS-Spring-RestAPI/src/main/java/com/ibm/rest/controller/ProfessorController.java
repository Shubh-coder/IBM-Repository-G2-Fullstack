package com.ibm.rest.controller;

 
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.MediaTray;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ibm.rest.DAO.ProfessorDAO;
import com.ibm.rest.bean.Student;
import com.ibm.rest.exception.GradeNotAssigned;
import com.ibm.rest.exception.NoDataFound;
import com.ibm.rest.exception.UserNotExists;

/*
*This is ProfessorController which contains professor related rest endpoints
*@author Shubham, Nishant, Kirubakaran, Ravikumar, Hemanth, Raghavendra
*/

@RestController
@CrossOrigin

public class ProfessorController {
	@Autowired
	private ProfessorDAO professorDAO;
	
	/**
	 * This is viewEnrolledStudents endpoint student operation
	 * @param studentId
	 * @return
	 */
	@JsonPropertyOrder(value= {"studentId"})
	@GetMapping("/professor/student")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getEnrolledStudent(){

 
			try {
				return professorDAO.getEnrolledStudent();
			} catch (NoDataFound e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return getEnrolledStudent();
	 
	}
	
	/**
	 * Add Grade Rest End point to add the grade for the studnet
	 * @param studentid,Grade
	 * @return
	 */
	
	@PostMapping(value = "/professor/student/{studentid}/{grade}")
	public String addGrade(@PathVariable int studentid, @PathVariable String grade) {
		try {
			System.out.println(studentid);
			System.out.println(grade);
			professorDAO.addGrade(studentid, grade);

		} catch (GradeNotAssigned e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserNotExists e) {
			// TODO Auto-generated catch block
			return "user not found "+ grade;
} 
		return "Grade added";

		}

	}
