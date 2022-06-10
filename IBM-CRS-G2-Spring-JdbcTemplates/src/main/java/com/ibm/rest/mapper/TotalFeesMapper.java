package com.ibm.rest.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.rest.bean.Course;
import com.ibm.rest.bean.TotalFees;

public class TotalFeesMapper  implements RowMapper<TotalFees> {

	@Override
	public TotalFees mapRow(ResultSet rs, int rowNum) throws SQLException {

		TotalFees totalfees = new TotalFees();

		totalfees.setCourse_Price(rs.getInt("Sum(Course_Price)"));

		return totalfees;
	}

}
