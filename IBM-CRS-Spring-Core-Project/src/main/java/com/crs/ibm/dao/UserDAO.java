package com.crs.ibm.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import com.crs.ibm.constant.SQLQueryConstant;
import com.crs.ibm.exception.AlreadyRegister;
import com.crs.ibm.exception.NoDataFound;
import com.crs.ibm.exception.UserNotExists;
import com.crs.ibm.utils.DBUtils;

public class UserDAO implements  UserDAOInterface {
	Scanner sc = new Scanner (System.in);
	Connection conn=null;

	/**
	 * Method for inserting all details of student
	 * @param name, qualification, branch, contact, address
	 * @exception UserNotExists
	 */

	public void StudentDetail(String name,String quali,String branch,String contact,String address)
	{
		conn=DBUtils.getConnection();	

		PreparedStatement stmt = null;
		//		   ResultSet rs=null; 
		try{

			stmt = conn.prepareStatement(SQLQueryConstant.INSERT_STUDENT_DETAIL);

			stmt.setString(1,name);
			stmt.setString(2,quali);
			stmt.setString(3,branch);
			stmt.setString(4,contact);
			stmt.setString(5,address);
			stmt.executeUpdate();
			//STEP 6: Clean-up environment
			System.out.println("succesfully inserted");
			//			      rs.close();
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

	/**
	 * Method for showing all user whose approval is pending
	 * @param mail id , user role,password,approval
	 * @exception UserNotExists
	 */

	public void allUser()
	{

		conn=DBUtils.getConnection();	

		PreparedStatement stmt = null;
		ResultSet rs=null; 
		try{

			stmt = conn.prepareStatement(SQLQueryConstant.VIEW_NOTAPPROVE_USERS);
			rs=stmt.executeQuery();
			System.out.println("");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.format("%25s %30s  %30s %14s %15s\n","Name","Email","Password","Role","Approval");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
			while(rs.next())
			{

				String Name = rs.getString("name");
				String Email=rs.getString("email");
				String Password=rs.getString("password");
				String Role = rs.getString("role");
				String Approval = rs.getString("approval");

				System.out.println("");
				//       System.out.println("Student Id:"+id  +"\tName:"+name +"\tQualification:"+qualification +"\tBranch:"+branch +"\tContact:" +contact +"\tAddress:" +address +"\tGrade:"+grade);
				System.out.format("%25s %30s  %30s %14s %15s\n",Name,Email,Password,Role,Approval);
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
	}

	public void passwordReviwer(String mail, String role) throws UserNotExists{

		conn=DBUtils.getConnection();	
		String rol=role;
		PreparedStatement stmt = null;
		ResultSet rs=null; 
		String pswd = null;


		try{
			String verify = "select * from user where email='"+mail+"'";
			stmt = conn.prepareStatement(verify); 
			rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println("Enter the new password");
				pswd = sc.next();

				stmt=null;
				stmt = conn.prepareStatement(SQLQueryConstant.CHANGE_PASSWORD);
				stmt.setString(1,pswd);
				stmt.setString(2,mail);

				int rowaf=  stmt.executeUpdate();
				System.out.println(String.format("Row affected %d", rowaf));

				rs.close();
				stmt.close();
				conn.close();

			}else {
				throw new UserNotExists();
			}
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
			}
		}   

	}
	public void userLoginTracker(String name, String role,String date) throws UserNotExists{

		conn=DBUtils.getConnection();	
		String rol=role;
		PreparedStatement stmt = null;
		ResultSet rs=null; 
		String pswd = null;


		try{
			String verify = SQLQueryConstant.LOGIN_TRACKER;
			stmt = conn.prepareStatement(verify); 
			stmt.setString(1,name);
			stmt.setString(2,role);
			stmt.setString(3,date);
			
			stmt.executeUpdate();
			
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
			}
		}   

	}


}



