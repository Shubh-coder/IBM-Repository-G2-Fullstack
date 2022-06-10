package com.ibm.rest.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.rest.bean.CourseReg;
import com.ibm.rest.bean.Grade;

public class GradeMapper  implements RowMapper<Grade>{

	public  Grade  mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Grade grade= new Grade();
		grade.setStudentGrade(rs.getString("grade"));
		return grade;
	}

}
