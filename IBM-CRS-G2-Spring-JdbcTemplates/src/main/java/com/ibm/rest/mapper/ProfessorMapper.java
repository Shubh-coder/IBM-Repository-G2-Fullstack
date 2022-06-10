package com.ibm.rest.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.rest.bean.Professor;


public class ProfessorMapper  implements RowMapper<Professor>{

	public Professor  mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Professor professor=new Professor();
		professor.setProfessorId(rs.getInt("Id"));
		professor.setProfessorName(rs.getString("Professor_Name"));
		professor.setDepartment(rs.getString("Professor_Department"));
		professor.setAddress(rs.getString("Professor_Address"));
		professor.setContact(rs.getLong("Professsor_contact"));

		return professor;
	}

}
