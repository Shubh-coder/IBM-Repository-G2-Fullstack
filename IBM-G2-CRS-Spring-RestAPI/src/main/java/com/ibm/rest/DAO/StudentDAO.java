package com.ibm.rest.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ibm.rest.bean.Course;
import com.ibm.rest.bean.Grade;
import com.ibm.rest.bean.Student;
import com.ibm.rest.bean.regcourse;
import com.ibm.rest.constant.SQLQueryConstant;
import com.ibm.rest.exception.CourseNotAdded;
import com.ibm.rest.exception.GradeNotAssigned;
import com.ibm.rest.exception.NotRegister;
import com.ibm.rest.exception.NotRemoved;
import com.ibm.rest.utils.DBUtils;
import com.mysql.jdbc.Statement;

@Repository
public class StudentDAO implements StudentDAOInterface{
	Connection conn = null;
	static int recsid=0;
	static double tamt = 0.0;


	//-----------------Add in Course available-------------------

	public List<Course>CourseRegistration() throws NotRegister
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


	//----------------------------View Register Courses---------------------

	public List<Course> ViewRegisterCourses(int studentid) throws NotRegister
	{/**
	 * Method to view available courses before registering
	 */
		conn=DBUtils.getConnection();	
		List<Course> registeredCourse= new ArrayList<Course>();
		PreparedStatement stmt = null;
		ResultSet rs=null; 

		try{

			stmt = conn.prepareStatement(SQLQueryConstant.VIEW_REGISTER_COURSES_STUDENT);
			stmt.setInt(1, studentid);
			rs=stmt.executeQuery();
			while(rs.next())
			{
		       Course rc= new Course();
		       rc.setCourseId(rs.getInt("id"));
		       rc.setCourseName(rs.getString("course_name"));
		       rc.setCoursePrice(rs.getInt("course_price"));
			  
		       registeredCourse.add(rc);
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
		return registeredCourse;
	}	



	//-----------------Add in Course New Course registration-------------------

	public boolean AddCourse(String cn, int stid, int crsid) throws CourseNotAdded {
		/**
		 * Method for the student to add their desired course
		 * 
		 * @param student_id and course_id
		 * @throws CourseNotFound
		 */
		// TODO Auto-generated method stub

		conn = DBUtils.getConnection();
		Statement s = null;
		String status = null;
		PreparedStatement stmt = null; 
		ResultSet rs = null;

		try{
             regcourse obj =new regcourse();
 
			stmt = conn.prepareStatement(SQLQueryConstant.ADD_COURSE_STUDENT);
			stmt.setString(1, cn);
			stmt.setInt(2,stid);
			stmt.setInt(3,crsid);

			int row= stmt.executeUpdate();
			System.out.println("created: "+row);

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
		return false;

	}//end main


	//-----------------Drop course-------------------	

	public void DropCourse(int studentid,int courseid) throws NotRemoved {
		/**
		 * Method for student to remove the course
		 * @param student_id and course_id
		 * @throws NotRemoved
		 */

		conn=DBUtils.getConnection();	

		PreparedStatement stmt = null;
		ResultSet rs=null; 


		try{

			System.out.println("deleting the course");

			stmt = conn.prepareStatement(SQLQueryConstant.DROP_COURSE_STUDENT);

			stmt.setInt(1, studentid);
			stmt.setInt(2, courseid);

			stmt.executeUpdate();
			System.out.println("deleted successfully");


			stmt.close();
			conn.close();


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

	//------------------------view Grade-----------------------------

	public List<Student> ViewGrade(int studentid) throws GradeNotAssigned{
		/**
		 * Method for student to view their grades
		 *@param srudent_id
		 *@throws GradeNotAssigned
		 * */
		conn=DBUtils.getConnection();
 
		PreparedStatement stmts = null;
		String status = null;
		ResultSet rs = null;

		List<Student> viewGrade= new ArrayList<Student>();
		try{
			status = "select grade from student where id="+studentid;
			if(status != null) {
		      System.out.println("hiie");
				stmts = conn.prepareStatement(SQLQueryConstant.VIEW_GRADE);
				 
				stmts.setInt(1, studentid);
				rs=stmts.executeQuery();
  				 
				while(rs.next())
				{	
					Student vg=new Student();
					vg.setStudentId(rs.getInt("id"));
					vg.setStudentGrade(rs.getString("grade"));
					viewGrade.add(vg);
					
				}
				if(rs==null) {
					throw new GradeNotAssigned();
				}
			}else {
				throw new GradeNotAssigned();
			}

			rs.close();
			stmts.close();
			conn.close();
		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmts!=null)
					stmts.close();
			}catch(SQLException se2){
			}

		}// nothing we can do
 
		return viewGrade;


	}

	//---------------------------------View Fees---------------------------------------	

	public List<Course>viewFees(int studentid) throws NotRegister {
		/**
		 * Method for student to view the total fee for their courses
		 * @param student_id
		 */
		int total =0;
		List<Course> viewfee = new ArrayList<Course>();
		 
		
		conn=DBUtils.getConnection();	

		PreparedStatement stmts = null;
		ResultSet rs=null; 

		try { 
			stmts=conn.prepareStatement(SQLQueryConstant.COURSE_F);
			stmts.setInt(1, studentid);
			rs= stmts.executeQuery();

			while(rs.next()) {
			     Course cr= new Course();
				 
				total+= rs.getInt("course_price");

				cr.setCourseId(rs.getInt("id"));
				cr.setCoursePrice(total);
			  
			 viewfee.add(cr);
			}
			System.out.println("Registered Course_ids= "+ viewfee );  
			System.out.println("fees="+ total);
			if(rs==null) {
				throw new NotRegister();
			}

			rs.close();
			stmts.close();

			conn.close();
			
		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
			throw new NotRegister();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmts!=null)
					stmts.close();
			}catch(SQLException se2){
			}

		}// nothing we can do
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}//end finally try
		
		 return viewfee;
		
	}
	
	
	 


	//-------------------------------Payment Fees-------------------------------------------	

	public String Payment_fees(int studentid, String paymode)
	{
		/**
		 * Method for student to view the total fee for their courses
		 * @param student_id and Payment_mode
		 */
		conn = DBUtils.getConnection();
		PreparedStatement stmt = null;
		int total_amount = 0;
		ResultSet rs = null;
		try{
			
			  stmt=conn.prepareStatement(SQLQueryConstant.COURSE_F);
			  
			  stmt.setInt(1,studentid);
			  
			  rs= stmt.executeQuery();
			  if(rs.next()) { 
			  this.recsid = rs.getInt("Id");
			  this.tamt = rs.getInt("Course_Price");
			  System.out.println("reg course id: "+this.recsid);
			  System.out.println("total amount: "+ this.tamt);
			  }
			 stmt=conn.prepareStatement(SQLQueryConstant.STUDENT_TOTAL_AMOUNT);

			stmt.setInt(1,studentid);
			rs = stmt.executeQuery();
			System.out.println(rs.getInt("course_price"));

			stmt=conn.prepareStatement(SQLQueryConstant.INSERT_PAYMENT);

			stmt.setInt(1,studentid);
			stmt.setString(2,paymode);
			stmt.setInt(3,this.recsid);
			stmt.setDouble(4,tamt);
			int row= stmt.executeUpdate();

			rs.close();
			stmt.close();
			conn.close();

		}catch(SQLException se)
		{
			se.printStackTrace();
		}
		return paymode;

	}

	/**
	 * Method for adding payment mode details(credit/debit card).
	 * @param Card_Number, Upi, Expiry_Date, CVV, StUdent_ID
	 */

	public void  pay_mode_detail(String cardno,String upi,String ex_date, int cvv,int studentid)
	{

		conn = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try{
			stmt=conn.prepareStatement(SQLQueryConstant.INSERT_PAYMENT_MODE_DETAIL);

			stmt.setString(1,cardno);
			stmt.setString(2,upi);
			stmt.setString(3,ex_date);
			stmt.setInt(4,cvv);
			stmt.setInt(5,studentid);
			int row=stmt.executeUpdate();
			System.out.println("submited"+row);


			stmt.close();
			conn.close();

		}catch(SQLException se)
		{
			se.printStackTrace();
		}


	}




}
