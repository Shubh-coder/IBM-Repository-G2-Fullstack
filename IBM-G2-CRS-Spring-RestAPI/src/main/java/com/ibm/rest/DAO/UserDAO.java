package com.ibm.rest.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.ibm.rest.bean.User;
import com.ibm.rest.constant.SQLQueryConstant;
import com.ibm.rest.exception.NoDataFound;
import com.ibm.rest.exception.UserNotExists;
import com.ibm.rest.utils.DBUtils;

@Repository
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

	public List<User> allUser()
	{

		conn=DBUtils.getConnection();	
		List<User> user= new ArrayList<User>();
		PreparedStatement stmt = null;
		ResultSet rs=null; 
		try{

			stmt = conn.prepareStatement(SQLQueryConstant.VIEW_NOTAPPROVE_USERS);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				User u=new User();
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				u.setRole(rs.getString("role"));
				u.setApproval(rs.getString("approval"));
				user.add(u);

				
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
		return user;
	}

	public void passwordChange(String mail, String role) throws UserNotExists{

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



