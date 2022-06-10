package com.crs.ibm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.crs.ibm.bean.*;
import com.crs.ibm.constant.SQLQueryConstant;
import com.crs.ibm.exception.GradeNotAssigned;
import com.crs.ibm.exception.NoDataFound;
import com.crs.ibm.exception.UserNotExists;
import com.crs.ibm.service.*;
import com.crs.ibm.utils.DBUtils;

import java.util.logging.*;
import java.util.Formatter;


public class ProfessorDAO implements ProfessorDAOInterface{
	Connection conn = null;

	Formatter fmt = new Formatter();  
	//------------------------------View All Student----------------------------------	

	public List<Student> getEnrolledStudent() throws NoDataFound
	{
		/**
		 * Method to fetch the student detail from the student table. 
		 * @param name, email, password, role
		 * @throw UserNotExists
		 */

		conn=DBUtils.getConnection();	
		List<Student> enrolledStudent= new ArrayList<Student>();

		PreparedStatement stmt = null;
		ResultSet rs=null; 
		try{

			stmt = conn.prepareStatement(SQLQueryConstant.VIEW_STUDENT_PROFESSOR);
			rs=stmt.executeQuery();
			System.out.println("");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.format("%14s %20s %30s %25s %14s %30s %14s\n","id","Name","Qualification","Branch","Contact","Address","Grade");  
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------"); 
			while(rs.next())
			{
				int id=rs.getInt("id");
				String name = rs.getString("name");
				String qualification=rs.getString("qualification");
				String branch=rs.getString("branch");
				String contact = rs.getString("contact");
				String address = rs.getString("address");
				String grade = rs.getString("grade");
				System.out.println("");

				System.out.format("%14s %20s %30s %25s %14s %30s %14s\n",id,name,qualification,branch,contact,address,grade);  
			}
			if(rs==null) {
				throw new NoDataFound();
			}


			//STEP 6: Clean-up environment
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
		return enrolledStudent;
	}


	//------------------------------Add grade for Student-------------------------	

	public void addGrade(int sid, String gd) throws GradeNotAssigned, UserNotExists
	{
		/**
		 * Method for the professor to add grades to the students
		 * @param student_id and a grade
		 */

		conn=DBUtils.getConnection();

		PreparedStatement stmt = null;

		try{
			int stid=sid;
			String stgrade=gd;
			//STEP 4: Execute a query

			stmt = conn.prepareStatement(SQLQueryConstant.ADD_GRADE_PROFESSOR);
			stmt.setString(1, gd);
			stmt.setInt(2, stid);
			int rowaf=  stmt.executeUpdate();
			System.out.println(String.format("Row affected %d", rowaf));
			if(rowaf == 0) {
				throw new GradeNotAssigned(stgrade);
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

	}//end main

}




