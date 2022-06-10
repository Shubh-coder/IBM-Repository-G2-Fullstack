package com.ibm.rest.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


//import com.crs.ibm.service.UserService;
import com.ibm.rest.bean.Course;
import com.ibm.rest.bean.Professor;
import com.ibm.rest.configuration.JDBCConfiguration;
import com.ibm.rest.constant.SQLQueryConstant;
import com.ibm.rest.exception.AlreadyRegister;
import com.ibm.rest.exception.CourseNotAdded;
import com.ibm.rest.exception.NoDataFound;
import com.ibm.rest.exception.NotRegister;
import com.ibm.rest.exception.NotRemoved;
import com.ibm.rest.exception.ProfessorNotAssigned;
import com.ibm.rest.exception.UserNotApproved;
import com.ibm.rest.exception.UserNotExists;
import com.ibm.rest.mapper.CourseMapper;


@Repository
public class AdminDAO implements AdminDAOInterface{
	Connection conn=null;
	Logger logger = LoggerFactory.getLogger(AdminDAO.class);

	// DI injection of JDBCTemplate

	/*
	 * @Autowired private JdbcTemplate jdbcTemplateObject;
	 */
	@Autowired
	JDBCConfiguration jdbcConfiguration;

	static int user_id; 
	/**
	 * Method to display current date and time
	 * @param  date,time
	 * @throws 
	 * 
	 */
	public String displayCurrentDate() {

		Date currentDate = new Date();
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();

		String pattern = "MM/dd/yyyy HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		Date today = Calendar.getInstance().getTime();        
		String todayAsString = df.format(today);

		return todayAsString; 

	}

	/**
	 * Method to approve student
	 * @param email
	 * @throws 
	 * 
	 */
	@Transactional
	public void approveStudent(String email)
	{


		String SQL = SQLQueryConstant.APPROVAL;
		jdbcConfiguration.jdbcTemplate().update(SQL, email);
		System.out.println("Updated Record with ID = " + email );
		return;

	}




	//------------------------ADD Course-------------------------------------


	public void addCourse(int courseid,String coursename,String coursesection,String coursetype,int coursemax,double courseprice,int courseduration, int professorid) throws CourseNotAdded{
		/**
		 * Method to add courses to the course table 
		 * @param course_id, Course_type, course_limit etc..
		 * @throws CourseNotAdded
		 */
		String SQL = SQLQueryConstant.ADD_COURSE_ADMIN;

		jdbcConfiguration.jdbcTemplate().update( SQL,courseid, coursename, coursesection, coursetype, coursemax,  courseprice, courseduration, professorid);
		System.out.println("Created Record  Id = " + courseid + " Name = " +coursename );

		return;


	}



	//--------------------------------Delete course------------------------


	public void deleteCourse (int courseid) throws NotRemoved
	{
		/**
		 * Method to remove courses from the course table 
		 * @param course_id
		 * @throws NotRemoved
		 */

		String SQL = SQLQueryConstant.DELETE_COURSE_ADMIN;
		jdbcConfiguration.jdbcTemplate().update(SQL, courseid);
		System.out.println("Deleted Record with ID = " + courseid );
		return;


	}

	//------------------method to assign professor to a course ---------------
	public void assignProfessor(int courseid,int professorid) throws ProfessorNotAssigned {
		/**
		 * Method to assign a professor for a course
		 * @param professor_id and course_id
		 * @exception ProfessorNotAssigned
		 */

		String SQL = SQLQueryConstant.ASSIGN_PROFESSOR;
		jdbcConfiguration.jdbcTemplate().update(SQL,professorid,courseid);
		System.out.println("Assigned professor Id  ="+professorid+" to the course id " + courseid );
		return; 
	}
	//---------Method to view all courses--------------

	public List<Course>AllCourses() throws NotRegister
	{/**
	 * Method to register the course before adding 
	 */


		String SQL = SQLQueryConstant.ALL_COURSES;
		List <Course> course = jdbcConfiguration.jdbcTemplate().query(SQL, new CourseMapper());
		logger.debug("in debug");
		return course;

	}


}







