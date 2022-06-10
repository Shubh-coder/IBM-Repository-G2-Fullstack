package com.ibm.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.rest.bean.Course;
import com.ibm.rest.bean.Grade;
import com.ibm.rest.bean.Student;
import com.ibm.rest.bean.TotalFees;
import com.ibm.rest.configuration.JDBCConfiguration;
import com.ibm.rest.bean.CourseReg;
import com.ibm.rest.constant.SQLQueryConstant;
import com.ibm.rest.exception.CourseNotAdded;
import com.ibm.rest.exception.GradeNotAssigned;
import com.ibm.rest.exception.NotRegister;
import com.ibm.rest.exception.NotRemoved;
import com.ibm.rest.mapper.CourseMapper;
import com.ibm.rest.mapper.CourseRegMapper;
import com.ibm.rest.mapper.GradeMapper;
import com.ibm.rest.mapper.StudentMapper;
import com.ibm.rest.mapper.TotalFeesMapper;
import com.mysql.jdbc.Statement;

@Repository
public class StudentDAO implements StudentDAOInterface{
	static int recsid=0;
	static double tamt = 0.0;

	Logger logger = LoggerFactory.getLogger(StudentDAO.class);

	// DI injection of JDBCTemplate

	/*
	 * @Autowired private JdbcTemplate jdbcTemplateObject;
	 */
	@Autowired
	JDBCConfiguration jdbcConfiguration;

	//-----------------List Of Course available-------------------
	@Transactional
	public List<Course>CourseList() throws NotRegister
	{/**
	 * Method to  showing list of course
	 */

		String SQL = SQLQueryConstant.VIEW_COURSE_STUDENT;
		List <Course> courses = jdbcConfiguration.jdbcTemplate().query(SQL,new CourseMapper());
		logger.debug("in debug");
		return courses;


	}	


	//----------------------------View Register Courses---------------------
	@Transactional
	public List<CourseReg> ViewRegisterCourses(int studentid) throws NotRegister
	{/**
	 * Method to view registered courses by student
	 */
		String SQL = "select * from course_reg where student_id = ?";
		List <CourseReg> coursereg = jdbcConfiguration.jdbcTemplate().query(SQL,new CourseRegMapper(),studentid);
		logger.debug("in debug");
		return coursereg;

	}	



	//-----------------Add in Course New Course registration-------------------

	public void AddCourse(String coursename, int studentid, int courseid) throws CourseNotAdded {
		/**
		 * Method for the student to add their desired course
		 * 
		 * @param student_id and course_id
		 * @throws CourseNotFound
		 */

		String SQL = SQLQueryConstant.ADD_COURSE_STUDENT;

		jdbcConfiguration.jdbcTemplate().update( SQL,coursename, studentid,courseid);
		System.out.println("Course registered successfully with Id = " + courseid + " and Name = " +coursename + "to Student with Id= "+studentid);
		return;



	}


	//-----------------Drop course-------------------	

	public void DropCourse(int studentid,int courseid) throws NotRemoved {
		/**
		 * Method for student to remove the course
		 * @param student_id and course_id
		 * @throws NotRemoved
		 */
		String SQL = SQLQueryConstant.DROP_COURSE_STUDENT;
		jdbcConfiguration.jdbcTemplate().update(SQL, studentid,courseid);
		System.out.println("Deleted course  "+courseid+"  of Student = " +studentid );
		return;


	}

	//------------------------view Grade-----------------------------

	public List<Grade> ViewGrade(int studentid) throws GradeNotAssigned{
		/**
		 * Method for student to view their grades
		 *@param srudent_id
		 *@throws GradeNotAssigned
		 * */
		String SQL =SQLQueryConstant.VIEW_GRADE;
		List <Grade>  grade = jdbcConfiguration.jdbcTemplate().query(SQL,new GradeMapper(),studentid);
		logger.debug("in debug");
		return grade;

	}

	//---------------------------------View Fees---------------------------------------	

	public List<TotalFees>viewFees(int studentid) throws NotRegister {
		/**
		 * Method for student to view the total fee for their courses
		 * @param student_id
		 */

		String SQL =SQLQueryConstant.COURSE_F;
		List <TotalFees>  coursefees = jdbcConfiguration.jdbcTemplate().query(SQL,new TotalFeesMapper(),studentid);

		logger.debug("in debug");
		System.out.println(coursefees);
		return coursefees;



	}

	//-------------------------------Payment Fees-------------------------------------------	

	public void Payment_fees(int studentid, String paymode)
	{
		/**
		 * Method for student to view the total fee for their courses
		 * @param student_id and Payment_mode
		 */

		String SQL= SQLQueryConstant.COURSE_F;
		List <TotalFees>  coursefees = jdbcConfiguration.jdbcTemplate().query(SQL,new TotalFeesMapper(),studentid);
		int a=((coursefees.get(0)).getCourse_Price());


		String SQL2 =SQLQueryConstant.INSERT_PAYMENT;
		jdbcConfiguration.jdbcTemplate().update( SQL2,paymode,a,studentid);
		System.out.println("Created Record ");

		return;

	}

	/**
	 * Method for adding payment mode details(credit/debit card).
	 * @param Card_Number, Upi, Expiry_Date, CVV, StUdent_ID
	 */

	public void  pay_mode_detail(String cardno,String upi,String ex_date, int cvv,int studentid)
	{

		String SQL =SQLQueryConstant.INSERT_PAYMENT_MODE_DETAIL;
		jdbcConfiguration.jdbcTemplate().update( SQL,cardno,upi,ex_date,cvv,studentid);
		System.out.println("Created Record ");
		return;

	}
}
