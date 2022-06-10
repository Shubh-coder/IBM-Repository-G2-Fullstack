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

import com.ibm.rest.bean.User;
import com.ibm.rest.dao.UserDAO;
import com.ibm.rest.exception.AlreadyRegister;
import com.ibm.rest.exception.UserNotApproved;
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
	public String StudentDetails(@RequestBody Map<String, String> student_details) {

		String name = student_details.get("name");
		String qualification = student_details.get("qualification");
		String branch = student_details.get("branch");
		String contact = student_details.get("contact");
		String address = student_details.get("address");
		userdao.StudentDetail(name, qualification, branch, contact, address);
		return "student  details added";
	}

	/**
	 * new registration restEndPoint is used by the admin to save the  new user details into database
	 * @param name, email, password, role
	 * @return not register 
	 * url : "/user/registration"
	 * description: This method adds the new user
	 */
	@PostMapping("/user/registration")
	public String Newregistration(@RequestBody Map<String, String> userMap){

		String name = userMap.get("name");
		String email = userMap.get("email");
		String password = userMap.get("Password");
		String role = userMap.get("role");
		try {
			userdao.Newregistration(name, email, password, role);
		} catch (AlreadyRegister e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Registration completed as a "+ role;

	}

	/**
	 * 
	 * @param email, password
	 * @return sucessful login
	 * url : "/admin/loginAuth/"
	 * description: This method checks the email and password of a user in database and verifies before login
	 */

	@GetMapping("/admin/loginAuth/{email}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public String LoginUser(@PathVariable String email,@PathVariable String password) throws UserNotApproved
	{
		try {
			userdao.LoginUser(email, password);
		} catch (UserNotApproved e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserNotExists e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login successful";
	}
	@PostMapping("/user/passwordchange")
	@Produces(MediaType.APPLICATION_JSON)	
	public String passwordChange(@RequestBody Map<String, String> userMap){

		String email = userMap.get("Email");
		String password = userMap.get("Password");
		try {
			userdao.passwordChange(email, password);
		} catch (UserNotExists e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "password changeed successfully";
	}



}