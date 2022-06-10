package com.ibm.rest.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.rest.bean.Course;
import com.ibm.rest.dao.AdminDAO;
import com.ibm.rest.exception.AlreadyRegister;
import com.ibm.rest.exception.CourseNotAdded;
import com.ibm.rest.exception.NoDataFound;
import com.ibm.rest.exception.NotRegister;
import com.ibm.rest.exception.NotRemoved;
import com.ibm.rest.exception.ProfessorNotAssigned;
import com.ibm.rest.exception.UserNotApproved;

/**
 * This is AdminController class where admin related end points are there
 * 
 * @author Shubham, Nishant, Kirubakaran, Ravikumar, Hemanth, Raghavendra
 *  
 */

@RestController
@CrossOrigin
public class AdminController {
	@Autowired
	private AdminDAO adminDao;

	/**
	 * 
	 * @param email
	 * url : "/approveStudent"
	 * description : In this method student is approved by the admin 
	 */

	@PutMapping("/admin/approveStudent/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public String approveStudent(@PathVariable String email) {
		adminDao.approveStudent(email);
		return "Student Succesfully Approved";
	}

	/**
	 * save course restEndPoint is used by the admin to save the new course details into database
	 * @param course
	 * @return the course addition success or fail 
	 * url : "/addCourse"
	 * description: This method adds the course to the respective DB Table
	 */
	@PostMapping("/admin/addCourse")
	public String addCourse(@RequestBody Map<String, String> userMap){

		String course_id = userMap.get("courseId");
		String coursName = userMap.get("courseName");
		String courseSection = userMap.get("courseSection");
		String courseType = userMap.get("courseType");
		String courseMax = userMap.get("courseMax");
		String coursePrice = userMap.get("coursePrice");
		String courseDuration = userMap.get("courseDuration");
		String courseProfessorId = userMap.get("courseProfessorId");

		try {
			adminDao.addCourse(Integer.parseInt(course_id) , coursName, courseSection, courseType, Integer.parseInt(courseMax),Double.parseDouble(coursePrice), Integer.parseInt(courseDuration), Integer.parseInt(courseProfessorId));
		} catch (NumberFormatException | CourseNotAdded e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		adminDao.insert(userMap);

		return "Course added to the database";
	}

	/**
	 * Delete the course by course id by the admin
	 * 
	 * @param id
	 * url : "/deletecourse/{courseid}"
	 * description: This method deletes the course from the respective DB Table
	 */

	@DeleteMapping(value="/admin/deletecourse/{courseid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteCourse (@PathVariable int courseid){
		try {
			adminDao.deleteCourse(courseid);
		} catch (NotRemoved e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Course deleted successfully" + courseid;
	}

	/**
	 * 
	 * @param courseid, professorid
	 * uel : "/assignprofessor/"
	 * description : In this method admin asssigns professor to perticular course
	 */

	@PutMapping(value="/admin/assignprofessor/{courseid}/{professorid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String assignProfessor (@PathVariable int courseid,@PathVariable int professorid) {
		try {
			adminDao.assignProfessor(courseid, professorid);
		} catch (ProfessorNotAssigned e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Assigned professor: "+ professorid + "to course code: "+courseid;
	}

	/**
	 * 
	 * @param course
	 * @return the course addition success or fail 
	 * url : "/Courses"
	 * description: This method view the courses from  the respective DB Table
	 */

	@GetMapping("/admin/courses")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> AllCourse()
	{
		try {
			return adminDao.AllCourses();
		} catch (NotRegister e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return  AllCourse();
	}



}
