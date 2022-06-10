package com.ibm.rest.DAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.rest.bean.Student;
import com.ibm.rest.constant.SQLQueryConstant;
import com.ibm.rest.exception.GradeNotAssigned;
import com.ibm.rest.exception.NoDataFound;
import com.ibm.rest.exception.UserNotExists;
import com.ibm.rest.utils.DBUtils;

import java.util.logging.*;

import org.springframework.stereotype.Repository;

import java.util.Formatter;

@Repository
public class ProfessorDAO implements ProfessorInterface {
	Connection conn = null;

	Formatter fmt = new Formatter();
	// ------------------------------View All
	// Student----------------------------------

	public List<Student> getEnrolledStudent() throws NoDataFound {
		/**
		 * Method to fetch the student detail from the student table.
		 * 
		 * @param name, email, password, role
		 * @throw UserNotExists
		 */

		conn = DBUtils.getConnection();
		List<Student> enrolledStudent = new ArrayList<Student>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			stmt = conn.prepareStatement(SQLQueryConstant.VIEW_STUDENT_PROFESSOR);
			rs = stmt.executeQuery();
			 while (rs.next()) {
 
				  System.out.println("");
				  Student student =new Student();
				  
				  student.setStudentId(rs.getInt("id")); 
				  student.setStudentName(rs.getString("name")); 
				  student.setStudentQualification(rs.getString("qualification"));
				  student.setStudentBranch(rs.getString("branch"));
				  student.setStudentContactNo(rs.getString("contact"));
				  student.setStudentAddress(rs.getString("address"));
				  student.setStudentGrade(rs.getString("grade")); 
				  
				  enrolledStudent.add(student);
		  
			}
			if (rs == null) {
				throw new NoDataFound();
			}

			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		return enrolledStudent;
	}

	// ------------------------------Add grade for Student-------------------------

	public void addGrade(int studentid, String grade) throws GradeNotAssigned, UserNotExists {
		/**
		 * Method for the professor to add grades to the students
		 * 
		 * @param student_id and a grade
		 */

		conn = DBUtils.getConnection();

		PreparedStatement stmt = null;

		try {
			int stid = studentid;
			String stgrade = grade;
			// STEP 4: Execute a query

			stmt = conn.prepareStatement(SQLQueryConstant.ADD_GRADE_PROFESSOR);
			stmt.setString(1, grade);
			stmt.setInt(2, stid);
			int rowaf = stmt.executeUpdate();
			System.out.println(String.format("Row affected %d", rowaf));
			if (rowaf == 0) {
				throw new GradeNotAssigned(stgrade);
			}
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC

			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}// end main

}
