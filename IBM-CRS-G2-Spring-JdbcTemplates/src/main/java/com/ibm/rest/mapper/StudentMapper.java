/**
 * 
 */
package com.ibm.rest.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.rest.bean.Course;
import com.ibm.rest.bean.Student;

/**
 * @author 003NRH744
 *private int StudentId;
	private String StudentName;
	private String StudentQualification;
	private String StudentBranch;
	private String StudentContactNo;
	private String StudentAddress;
	private String studentGrade;
 */
public class StudentMapper  implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student= new Student();
		student.setStudentId(rs.getInt("Id"));
		student.setStudentName(rs.getString("name"));
		student.setStudentQualification(rs.getString("qualification"));
		student.setStudentBranch(rs.getString("branch"));
		student.setStudentContactNo(rs.getString("contact"));
		student.setStudentAddress(rs.getString("address"));
		student.setStudentGrade(rs.getString("grade"));
		return student;
	}

}
