package com.ibm.rest.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.ibm.rest.bean.Student;
import com.ibm.rest.configuration.JDBCConfiguration;
import com.ibm.rest.constant.SQLQueryConstant;
import com.ibm.rest.exception.GradeNotAssigned;
import com.ibm.rest.exception.NoDataFound;
import com.ibm.rest.exception.UserNotExists;
import com.ibm.rest.mapper.StudentMapper;

import java.util.logging.*;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Formatter;

@Repository
public class ProfessorDAO implements ProfessorInterface {

	Logger logger = LoggerFactory.getLogger(ProfessorDAO.class);


	/*
	 * @Autowired private JdbcTemplate jdbcTemplateObject;
	 */
	@Autowired
	JDBCConfiguration jdbcConfiguration;

	@Transactional
	public List<Student> getEnrolledStudent() throws NoDataFound {
		/**
		 * Method to fetch the student detail from the student table.
		 * 
		 * @param name, email, password, role
		 * @throw UserNotExists
		 */
		String SQL = "select * from student";
		List <Student> student = jdbcConfiguration.jdbcTemplate().query(SQL, new StudentMapper());
		logger.debug("in debug");
		return student;


	}

	// ------------------------------Add grade for Student-------------------------
	@Transactional
	public void addGrade(int studentid, String grade) throws GradeNotAssigned, UserNotExists {
		/**
		 * Method for the professor to add grades to the students
		 * 
		 * @param student_id and a grade
		 */

		String SQL = "Update student SET grade=? where id=?";
		jdbcConfiguration.jdbcTemplate().update(SQL, grade, studentid);
		System.out.println("Updated Record with ID = " + studentid );
		return;
	}
}