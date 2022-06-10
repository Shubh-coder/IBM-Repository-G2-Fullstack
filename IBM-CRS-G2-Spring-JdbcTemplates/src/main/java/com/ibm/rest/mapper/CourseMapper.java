/**
 * 
 */
package com.ibm.rest.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.rest.bean.Course;

/**
 * @author 003NRH744
 *  private int CourseId;
 	private String CourseName;
	private String CourseSection;
	private int CourseDuration;
	private String CourseType;
	private String CourseStatus;
	private int CoursePrice;
	private int ProfessorId;
 */


public class CourseMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

		Course course = new Course();
		course.setCourseId(rs.getInt("Id"));
		course.setCourseName(rs.getString("course_name"));
		course.setCourseSection(rs.getString("Course_Section"));
		course.setCourseDuration(rs.getInt("Course_Duration"));
		course.setCourseStatus(rs.getString("Course_Status"));
		course.setProfessorId(rs.getInt("Professor_Id"));
		course.setCoursePrice(rs.getInt("Course_Price"));

		return course;
	}
}
