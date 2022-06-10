/**
 * 
 */
package com.ibm.rest.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.rest.bean.CourseReg;

/**
 * @author 003NRH744
 *
 */
public class CourseRegMapper  implements RowMapper<CourseReg>{

	public  CourseReg  mapRow(ResultSet rs, int rowNum) throws SQLException
	{

		CourseReg coursereg =new CourseReg();

		coursereg.setCourse_name(rs.getString("course_name"));
		coursereg.setStudent_id(rs.getInt("student_id"));
		coursereg.setCourse_id(rs.getInt("course_id"));

		return coursereg;

	}

}
