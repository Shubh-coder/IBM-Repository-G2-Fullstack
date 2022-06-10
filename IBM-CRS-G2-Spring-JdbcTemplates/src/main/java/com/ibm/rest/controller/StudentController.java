package com.ibm.rest.controller;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.rest.bean.Course;
import com.ibm.rest.bean.CourseReg;
import com.ibm.rest.bean.Grade;
import com.ibm.rest.bean.Student;
import com.ibm.rest.bean.TotalFees;
import com.ibm.rest.dao.StudentDAO;
import com.ibm.rest.exception.CourseNotAdded;
import com.ibm.rest.exception.GradeNotAssigned;
import com.ibm.rest.exception.NotRegister;
import com.ibm.rest.exception.NotRemoved;

/**
 * StudentController class includes all the rest endpoints of student operations
 * 
 * @author Shubham, Nishant, Kirubakaran, Ravikumar, Hemanth, Raghavendra
 */

@RestController
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentDAO studentdao;



	/**
	 * 
	 * @param course
	 * @return the course addition success or fail 
	 * url : "/student/Courses"
	 * description: This method view the courses from  the respective DB Table
	 */
	@GetMapping("/student/courses")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> CourseList()
	{
		try {
			return studentdao.CourseList();
		} catch (NotRegister e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return CourseList();
	}

	/**
	 * save course restEndPoint is used by the student to save the registered course details into database
	 * @param course
	 * @return the course addition success or fail 
	 * url : "/addCourse"
	 * description: This method adds the registered course to the respective DB Table
	 */

	@PostMapping("/student/addCourse")
	public String addCourse(@RequestBody Map<String, String> userMap){

		String coursName = userMap.get("course_name");
		String StudentID = userMap.get("student_id");
		String course_id = userMap.get("course_id");


		try {
			studentdao.AddCourse(coursName, Integer.parseInt(StudentID),Integer.parseInt(course_id));
		} catch (NumberFormatException | CourseNotAdded e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Course added to the student table";
	}

	/**
	 * 
	 * @param studentid
	 * @return regester course 
	 * url : "/regcourse/{studentid}"
	 * description: This method shows the registered courses for student from respective DB Table
	 */

	@GetMapping("/student/regcourse/{studentid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CourseReg> ViewRegisterCourses(@PathVariable int studentid)
	{
		try {
			return studentdao.ViewRegisterCourses(studentid);
		} catch (NotRegister e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ViewRegisterCourses(studentid);

	}

	/**
	 * Delete the course by course id by the student
	 * 
	 * @param studentid, courseid
	 * url : "/deletecourse/{courseid}"
	 * description: This method deletes the course from the respective DB Table
	 */

	@DeleteMapping(value="/student/regcourse/{studentid}/{courseid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String DropCourse(@PathVariable int studentid,@PathVariable int courseid) throws NotRemoved
	{
		studentdao.DropCourse(studentid, courseid);


		return "successfully deleted"+HttpStatus.OK;
	}


	/**
	 * view grade
	 * 
	 * @param id
	 * url : /student/grade/{studentid}
	 * description: This method shows grades of student
	 */
	@GetMapping("/student/grade/{studentid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Grade> ViewGrade(@PathVariable int studentid)
	{

		try {
			return studentdao.ViewGrade(studentid);
		} catch (GradeNotAssigned e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ViewGrade(studentid);



	}

	/**
	 * view fees
	 * 
	 * @param studentid
	 * url : /student/viewfess/{studentid}
	 * description: This method shows grades of student
	 */

	@GetMapping("/student/viewfees/{studentid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TotalFees> viewFees(@PathVariable int studentid) 
	{
		try {
			return studentdao.viewFees(studentid);
		} catch (NotRegister e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return viewFees(studentid);
	}


	/**
	 * pay fees
	 * 
	 * @param studentid/ paymode
	 * url: student/payfess/{studentid}/{paymode}
	 * description: This method allows student to pay the course fees
	 */



	@PostMapping("student/payfess/{studentid}/{paymode}")
	@Produces(MediaType.APPLICATION_JSON)
	public String Payment_fees(@PathVariable int studentid,@PathVariable String paymode) {

		studentdao.Payment_fees(studentid, paymode);

		return "Payment Successfull";
	}


	/**
	 * save card details restEndPoint is used by the student to save the payment details into database
	 * @param cardNo, Upi, expirydate,cvv, studentId
	 * @return the course addition success or fail 
	 * url : "student/cardDetails"
	 * description: This method adds the registered course to the respective DB Table
	 */

	@PostMapping("student/cardDetails")
	public String cardDetails(@RequestBody Map<String, String> card_details) {

		String cardNo = card_details.get("cardNo");
		String upi = card_details.get("upi");
		String exDate = card_details.get("exDate");
		String cvv = card_details.get("cvv");
		String StudentID = card_details.get("studentId");
		studentdao.pay_mode_detail(cardNo, upi, exDate, Integer.parseInt(cvv),Integer.parseInt(StudentID));

		return "card details added";
	}



}


