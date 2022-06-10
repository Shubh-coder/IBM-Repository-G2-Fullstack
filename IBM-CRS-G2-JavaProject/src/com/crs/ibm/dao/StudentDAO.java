package com.crs.ibm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.crs.ibm.bean.Course;
import com.crs.ibm.constant.SQLQueryConstant;
import com.crs.ibm.exception.CourseNotAdded;
import com.crs.ibm.exception.CourseNotFound;
import com.crs.ibm.exception.GradeNotAssigned;
import com.crs.ibm.exception.NotRegister;
import com.crs.ibm.exception.NotRemoved;
import com.crs.ibm.utils.DBUtils;
import com.mysql.jdbc.Statement;

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
		List<Course> availabelCourse= new ArrayList<Course>();

		PreparedStatement stmt = null;
		ResultSet rs=null; 

		try{

			stmt = conn.prepareStatement(SQLQueryConstant.VIEW_COURSE_STUDENT);
			rs=stmt.executeQuery();
			System.out.println(""); 
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.format("%15s %30s %30s %15s %15s %15s\n","Id","Course_Name","Course_Section","course_type","Course_status","Course_Price");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			while(rs.next())
			{
				int id=rs.getInt("id");
				String Course_Name = rs.getString("course_name");
				String Course_Section=rs.getString("course_section");
				String Course_Type=rs.getString("course_type");
				String Course_Status = rs.getString("course_status");
				String Course_Price = rs.getString("course_price");
				System.out.println("");

				System.out.format("%15s %30s %30s %15s %15s %15s\n",id,Course_Name,Course_Section,Course_Type,Course_Status,Course_Price);
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
		return availabelCourse;
	}	


	//----------------------------View Register Courses---------------------

	public List<Course> ViewRegisterCourses(int stid) throws NotRegister
	{/**
	 * Method to view available courses before registering
	 */
		conn=DBUtils.getConnection();	
		List<Course> availableCourse= new ArrayList<Course>();
		PreparedStatement stmt = null;
		ResultSet rs=null; 

		try{

			stmt = conn.prepareStatement(SQLQueryConstant.VIEW_REGISTER_COURSES_STUDENT);
			stmt.setInt(1, stid);
			rs=stmt.executeQuery();
			System.out.println(""); 
			System.out.println("------------------------------------------------------------------------------------");
			System.out.format("%15s %30s %30s\n","Id","Course_Name","Course_Price");
			System.out.println("------------------------------------------------------------------------------------");
			while(rs.next())
			{
				int id=rs.getInt("id");
				String Course_Name = rs.getString("course_name");
				String Course_Price = rs.getString("course_price");
				System.out.println("");

				System.out.format("%15s %30s %30s\n",id,Course_Name,Course_Price);
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



	//-----------------Add in Course New Course registration-------------------

	public void AddCourse(String cn, int stid, int crsid) throws CourseNotAdded {
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

	}//end main


	//-----------------Drop course-------------------	

	public void DropCourse(int sid,int cid) throws NotRemoved {
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

			stmt.setInt(1, sid);
			stmt.setInt(2, cid);

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

	public void ViewGrade(int studid) {
		/**
		 * Method for student to view their grades
		 *@param srudent_id
		 *@throws GradeNotAssigned
		 * */
		Connection conn = null;
		PreparedStatement stmts = null;
		String status = null;
		ResultSet rs = null;

		try{
			status = "select grade from student where id="+studid;
			if(status != null) {

				rs=stmts.executeQuery("select course.course_id,student.grade from course inner join student on course.course_id = student.Student_id where student.studentId = ?");
				//			     "select course.course_id,student.grade from course inner join student on course.course_id = student.Student_id where student.studentId = ?";
				stmts.setInt(1, studid);
				while(rs.next())
				{
					System.out.println("courseid="+rs.getInt("courseid"));
					System.out.println("grades="+rs.getString("grades"));
					System.out.println("");
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
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException se){
			se.printStackTrace();

		}//end finally try


	}

	//---------------------------------View Fees---------------------------------------	

	public void viewFees(int stdid) throws NotRegister {
		/**
		 * Method for student to view the total fee for their courses
		 * @param student_id
		 */
		int total =0;
		ArrayList<Integer> course_id = new ArrayList();	
		conn=DBUtils.getConnection();	

		PreparedStatement stmts = null;
		ResultSet rs=null; 

		try { 
			stmts=conn.prepareStatement(SQLQueryConstant.COURSE_F);
			stmts.setInt(1, stdid);
			rs= stmts.executeQuery();

			while(rs.next()) {
				course_id.add(rs.getInt("id"));
				total += rs.getInt("course_price");
			}
			System.out.println("Registered Course_ids= "+ course_id );  
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
		
		 
		
	}
	
	
	 


	//-------------------------------Payment Fees-------------------------------------------	

	public void Payment_fees(int stid, String paymode)
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
			  
			  stmt.setInt(1,stid);
			  
			  rs= stmt.executeQuery();
			  if(rs.next()) { 
			  this.recsid = rs.getInt("Id");
			  this.tamt = rs.getInt("Course_Price");
			  System.out.println("reg course id: "+this.recsid);
			  System.out.println("total amount: "+ this.tamt);
			  }
			 stmt=conn.prepareStatement(SQLQueryConstant.STUDENT_TOTAL_AMOUNT);

			stmt.setInt(1,stid);
			rs = stmt.executeQuery();
			System.out.println(rs.getInt("course_price"));

			stmt=conn.prepareStatement(SQLQueryConstant.INSERT_PAYMENT);

			stmt.setInt(1,stid);
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

	}

	/**
	 * Method for adding payment mode details(credit/debit card).
	 * @param Card_Number, Upi, Expiry_Date, CVV, StUdent_ID
	 */

	public void  pay_mode_detail(String cardno,String upi,String ex_date, int cvv,int stid)
	{

		conn = DBUtils.getConnection();
		PreparedStatement stmt = null;

		try{
			stmt=conn.prepareStatement(SQLQueryConstant.INSERT_PAYMENT_MODE_DETAIL);

			stmt.setString(1,cardno);
			stmt.setString(2,upi);
			stmt.setString(3,ex_date);
			stmt.setInt(4,cvv);
			stmt.setInt(5,stid);
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
