package com.ibm.rest.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.rest.DAO.UserDAO;
import com.ibm.rest.bean.User;
import com.ibm.rest.exception.UserNotExists;

/**
 * User controller class where login ,register & update password rest endpoints are existed
 * 
 * @author Shubham, Nishant, Kirubakaran, Ravikumar, Hemanth, Raghavendra
 */
@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserDAO userdao;
	

	/**
	 * 
	 * @param course
	 * @return user not registered
	 * url : "/users"
	 * description: This method shows all the registered user
	 */
	
	@GetMapping("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> allUser() 
	{
		return userdao.allUser();
	}
	

	/**
	 * 
	 * @param course
	 * @return student details added
	 * url : user/studentDetails
	 * description: This method saves the student details such as name, qualification,etc. in the respective table in DB
	 */
	@PostMapping("user/studentDetails")
	public String cardDetails(@RequestBody Map<String, String> student_details) {
		
		String name = student_details.get("name");
	    String qualification = student_details.get("qualification");
	    String branch = student_details.get("branch");
	    String contact = student_details.get("contact");
	    String address = student_details.get("address");
	    userdao.StudentDetail(name, qualification, branch, contact, address);
		return "student  details added";
	}
	
	@PostMapping("/user/passwordchange")
	@Produces(MediaType.APPLICATION_JSON)
	public String passwordChange(@PathVariable String mail,@PathVariable String role) throws UserNotExists{
	          
	     	userdao.passwordChange(mail, role);
			return "password matched";

	}
	
	
	
	
	
	
	
}