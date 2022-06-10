/**
 * 
 */
package com.ibm.rest.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.rest.bean.Login;
import com.ibm.rest.bean.User;

/**
 * @author 003NRH744
 *
 */
public class LoginMapper  implements RowMapper<Login>{

	public Login  mapRow(ResultSet rs, int rowNum) throws SQLException
	{ 
		Login login=new Login();
		login.setName(rs.getString("Name"));
		login.setEmail(rs.getString("Email"));
		login.setRole(rs.getString("Role"));
		login.setApproval(rs.getInt("approval"));
		login.setPassword(rs.getString("Password"));
		return login;

	}

}
