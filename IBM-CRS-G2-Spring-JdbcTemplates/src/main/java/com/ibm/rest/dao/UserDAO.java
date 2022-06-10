package com.ibm.rest.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.rest.bean.Course;
import com.ibm.rest.bean.Login;
import com.ibm.rest.bean.User;
import com.ibm.rest.configuration.JDBCConfiguration;
import com.ibm.rest.constant.SQLQueryConstant;
import com.ibm.rest.exception.AlreadyRegister;
import com.ibm.rest.exception.NoDataFound;
import com.ibm.rest.exception.UserNotApproved;
import com.ibm.rest.exception.UserNotExists;
import com.ibm.rest.mapper.CourseMapper;
import com.ibm.rest.mapper.LoginMapper;
import com.ibm.rest.mapper.UserMapper;

@Repository
public class UserDAO implements  UserDAOInterface {
	Scanner sc = new Scanner (System.in);
	Connection conn=null;
	Logger logger = LoggerFactory.getLogger(UserDAO.class);

	// DI injection of JDBCTemplate

	/*
	 * @Autowired private JdbcTemplate jdbcTemplateObject;
	 */
	@Autowired
	JDBCConfiguration jdbcConfiguration;

	//	----------------------New User Registration ---------------------

	public void Newregistration(String name, String email, String password, String role) throws AlreadyRegister {
		/**
		 * Method to register new user to the user table 
		 * @param name, email, password, role
		 * @throws AlreadyRegister
		 */
		String SQL = SQLQueryConstant.REGISTRATION_USER;

		jdbcConfiguration.jdbcTemplate().update( SQL,name, email,password, role);
		System.out.println("User registered successfully with Name = " + name + " and email = " + email + "role = "+role);
		return;

	}

	//--------------------------User Login---------------------
	public List<Login> LoginUser(String email, String password) throws UserNotApproved,UserNotExists	{

		String SQL = SQLQueryConstant.LOGIN_USER;
		List<Login> login=jdbcConfiguration.jdbcTemplate().query(SQL,new LoginMapper(),email,password);
		logger.debug("in debug");
		System.out.println(login);
		return login;

	}

	//-----------------------------User Details collection-----------	
	/**
	 * Method for inserting all details of student
	 * @param name, qualification, branch, contact, address
	 * @exception UserNotExists
	 */

	public void StudentDetail(String name,String quali,String branch,String contact,String address)
	{
		String SQL = SQLQueryConstant.INSERT_STUDENT_DETAIL;

		jdbcConfiguration.jdbcTemplate().update( SQL,name,quali,branch,contact,address);
		System.out.println("Student details added to student" +name);
		return;

	}

	//-----------------Show users pending for approval-----------
	/**
	 * Method for showing all user whose approval is pending
	 * @param mail id , user role,password,approval
	 * @exception UserNotExists
	 */
	@Transactional
	public List<User> allUser()
	{
		String SQL = SQLQueryConstant.VIEW_NOTAPPROVE_USERS;
		List <User> user = jdbcConfiguration.jdbcTemplate().query(SQL,new UserMapper());
		logger.debug("in debug");
		return user;
	}

	//----------------Change Password--------------------------------------
	public void passwordChange(String password, String email) throws UserNotExists{

		String SQL = SQLQueryConstant.CHANGE_PASSWORD;
		jdbcConfiguration.jdbcTemplate().update(SQL, password, email);
		System.out.println("Updated Record with ID = " + email );
		return;
	}
}



