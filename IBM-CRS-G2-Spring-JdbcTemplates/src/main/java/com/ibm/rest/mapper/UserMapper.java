/**
 * 
 */
package com.ibm.rest.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.rest.bean.Professor;
import com.ibm.rest.bean.User;

/**
 * @author 003NRH744
 *
 */
public class UserMapper implements RowMapper<User>{

	public User  mapRow(ResultSet rs, int rowNum) throws SQLException
	{ 
		User user= new User();

		user.setName(rs.getString("Name"));
		user.setEmail(rs.getString("Email"));
		user.setPassword(rs.getString("Password"));
		user.setRole(rs.getString("Role"));
		user.setApproval(rs.getInt("approval"));

		return user;

	}

}
