package com.ibm.rest.DAO;
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

import org.springframework.stereotype.Repository;

//import com.crs.ibm.service.UserService;
import com.ibm.rest.bean.Course;
import com.ibm.rest.bean.Professor;
import com.ibm.rest.constant.SQLQueryConstant;
import com.ibm.rest.exception.AlreadyRegister;
import com.ibm.rest.exception.CourseNotAdded;
import com.ibm.rest.exception.NoDataFound;
import com.ibm.rest.exception.NotRegister;
import com.ibm.rest.exception.NotRemoved;
import com.ibm.rest.exception.ProfessorNotAssigned;
import com.ibm.rest.exception.UserNotApproved;
import com.ibm.rest.exception.UserNotExists;
import com.ibm.rest.utils.DBUtils;

@Repository
public class AdminDAO implements AdminDAOInterface{

	Scanner sc= new Scanner(System.in);
	StudentDAOInterface sd = new StudentDAO();
	UserDAOInterface usr = new UserDAO();
	 

	Connection conn = null;
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
	public void approveStudent(String email)
	{


		conn=DBUtils.getConnection();	

		PreparedStatement stmt = null;
		ResultSet rs=null; 

		try{

			stmt = conn.prepareStatement(SQLQueryConstant.APPROVAL);
			stmt.setString(1, email);
			int row= stmt.executeUpdate();
			System.out.println("Approved"+row);

			stmt.close();
			conn.close();


		}catch(Exception t){
			//Handle errors for Class.forName
			t.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try

	}







	//	----------------------Appproval Registration ---------------------

	public void Newregistration(String name, String email, String password, String role) throws AlreadyRegister {
		/**
		 * Method to register new user to the user table 
		 * @param name, email, password, role
		 * @throws AlreadyRegister
		 */

		conn=DBUtils.getConnection();	

		PreparedStatement stmt = null;
		ResultSet rs=null; 

		try{

			stmt = conn.prepareStatement(SQLQueryConstant.REGISTRATION_USER);
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, password);
			stmt.setString(4, role);


			int rowaf=  stmt.executeUpdate();
			System.out.println(String.format("Row affected %d", rowaf));
			if (rowaf == 0) {
				throw new AlreadyRegister();
			}
			stmt.close();
			conn.close();


		}catch(Exception t){
			//Handle errors for Class.forName
			t.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try


	}

	//--------------------------Authenticate ----------------------------------	

	public void authenticateUser(String email, String password) throws UserNotApproved {
		/**
		 * Method to authenticate the user   using stream to split email  into name
		 * @param  email, password
		 * @throws UserNotExists
		 * UserService us= new UserService();
		 */
		String databaseUsername=null;
		String databasePassword=null;
		String databaseName=null;
		String role=null;
		PreparedStatement stmt = null;
		conn=DBUtils.getConnection();	
		ResultSet rs=null;
		String status =null;

		try {

			status = "select * from user where Email='" + email + "' && Password='" + password+ "' && approval=1'";
			String sql="select * from user where approval=1 && Email='" + email + "' && Password='" + password+ "' ";			   
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();


		 
			try {

				String roll=null;
				String user_role = null;
				String user_name = null;
				while (rs.next()) {
 
					databaseUsername = rs.getString("Email");
					databasePassword = rs.getString("Password");
					user_role = rs.getString("Role");
					user_name = rs.getString("Name");
					usr.userLoginTracker(user_name, user_role, displayCurrentDate());
				 
					Stream<String> stream = Stream.of(email.split("\\@")[0]);
			    	stream.forEach(p -> System.out.println("logged in as: "+p+"\t"+displayCurrentDate()));
			    	 
					roll =rs.getString("Role"); 
				}


				if (email.equals(databaseUsername) && password.equals(databasePassword)) {
					System.out.println("\n\nSuccessful Login!\n----");
					//us.UserSelection(roll);
				}else {
					//	    	throw new UserNotApproved(); 
					throw new UserNotExists(); 

				}
			}


			catch(UserNotExists e) {
				System.out.println(e.getMessage());
			}

		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try {
				if(rs!=null)
					rs.close();
			}catch(Exception e3)
			{

			}
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}finally{
				System.out.println("   ");}//end finally try
		}
	}//end tryf



	//------------------------ADD Course-------------------------------------


	public void addCourse(int courseid,String coursename,String coursesection,String coursetype,int coursemax,double courseprice,int courseduration, int professorid) throws CourseNotAdded{
		/**
		 * Method to add courses to the course table 
		 * @param course_id, Course_type, course_limit etc..
		 * @throws CourseNotAdded
		 */
		
		conn=DBUtils.getConnection();	
		List<Course> cs=new ArrayList<Course>();
		PreparedStatement stmt = null;
		//   ResultSet rs=null; 
		try {
			Course y=new Course();
		
			stmt = conn.prepareStatement(SQLQueryConstant.ADD_COURSE_ADMIN);
			System.out.println("");
			stmt.setInt(1,courseid);
			stmt.setString(2, coursename);
			stmt.setString(3,coursesection);
			stmt.setString(4,coursetype);
			stmt.setInt(5,coursemax);
			stmt.setDouble(6,courseprice);
			stmt.setInt(7,courseduration);
			stmt.setInt(8,professorid); 
			int rowaf= stmt.executeUpdate();

			System.out.println(String.format("Row affected %d", rowaf));
			if (rowaf == 0) {
				throw new CourseNotAdded();
			}
			stmt.close();
			conn.close();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try

	}



	//--------------------------------Delete course------------------------


	public void deleteCourse (int courseid) throws NotRemoved
	{
		/**
		 * Method to remove courses from the course table 
		 * @param course_id
		 * @throws NotRemoved
		 */

		conn=DBUtils.getConnection();	

		PreparedStatement stmt = null;
		//   ResultSet rs=null; 
		try{

			String status = "select * from course where id="+courseid;
			if ((status != null)){

				stmt = conn.prepareStatement(SQLQueryConstant.DELETE_COURSE_ADMIN);
				stmt.setInt(1, courseid);
				int row=stmt.executeUpdate();
				//  rs=stmt.executeQuery();
				System.out.println("successfully deleted");
				if(row==0) {
					throw new NotRemoved();}
				//rs.close();
				stmt.close();
				conn.close();
			} else 
				throw new NotRemoved();
		}catch(NotRemoved e) {
			System.out.println(e);
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
	}
	
	//------------------method to assign professor to a course ---------------
	public void assignProfessor(int courseid,int professorid) throws ProfessorNotAssigned {
		/**
		 * Method to assign a professor for a course
		 * @param professor_id and course_id
		 * @exception ProfessorNotAssigned
		 */
		
		conn=DBUtils.getConnection();	

		PreparedStatement stmt = null;
		ResultSet rs=null; 

		try{
			System.out.println("assigning a professor fora course...");		     
			stmt = conn.prepareStatement(SQLQueryConstant.ASSIGN_PROFESSOR);
			stmt.setInt(1, professorid);
			stmt.setInt(2, courseid);

			int rowaf=  stmt.executeUpdate();
			System.out.println(String.format("Row affected %d", rowaf));
			if (rowaf == 0) {
				throw new ProfessorNotAssigned();
			}
			stmt.close();
			conn.close();


		}catch(Exception t){
			//Handle errors for Class.forName
			t.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
	}
	//---------Method to view all courses--------------
	
	public List<Course>AllCourses() throws NotRegister
	{/**
	 * Method to register the course before adding 
	 */
		conn=DBUtils.getConnection();	
		List<Course> availableCourse= new ArrayList<Course>();

		PreparedStatement stmt = null;
		ResultSet rs=null; 

		try{

			stmt = conn.prepareStatement(SQLQueryConstant.VIEW_COURSE_STUDENT);
			rs=stmt.executeQuery();
			System.out.println(""); 
			 
			while(rs.next())
			{
	              Course cs =new Course();
	              
				  cs.setCourseId(rs.getInt("id")); 
				  cs.setCourseName(rs.getString("course_name")); 
				  cs.setCourseSection(rs.getString("course_section"));
				  cs.setCourseType(rs.getString("course_type"));
				  cs.setCourseStatus(rs.getString("course_status"));
				  cs.setCoursePrice(rs.getInt("course_price"));
				  cs.setProfessorId(rs.getInt("professor_id"));
				  
				  availableCourse.add(cs);
				    
			
			}

			rs.close();
			stmt.close();
			conn.close();

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try 
		return availableCourse;
	}

	 
}







