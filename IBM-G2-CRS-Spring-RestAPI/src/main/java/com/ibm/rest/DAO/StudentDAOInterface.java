package com.ibm.rest.DAO;

import java.util.List;

import com.ibm.rest.bean.Course;
import com.ibm.rest.bean.Grade;
import com.ibm.rest.bean.Student;
import com.ibm.rest.exception.CourseNotAdded;
import com.ibm.rest.exception.CourseNotFound;
import com.ibm.rest.exception.GradeNotAssigned;
import com.ibm.rest.exception.NotRegister;
import com.ibm.rest.exception.NotRemoved;

public interface StudentDAOInterface {


	public boolean AddCourse(String cn, int stid, int crsid) throws CourseNotAdded;
	/**
	 * Method for the student to add their desired course
	 * @param student_id and course_id
	 * @throws CourseNotFound
	 */
	public void DropCourse(int studentid,int courseid) throws NotRemoved;
	/**
	 * Method for student to remove the course
	 * @param student_id and course_id
	 * @throws NotRegister 
	 * @throws NotRemoved
	 */

	public List<Course> CourseRegistration() throws NotRegister;
	/**
	 * Method to register the course before adding 
	 */
	public  List<Course>viewFees(int studentid) throws NotRegister;
	/**
	 * Method for student to view the total fee for their courses
	 * @param student_id
	 */
	public List<Student> ViewGrade(int studentid) throws GradeNotAssigned;
	/**
	 * Method for student to view their grades
	 *@param srudent_id
	 * @return 
	 *@throws GradeNotAssigned
	 * */
	public String Payment_fees(int studentid, String paymode);
	/**
	 * Method for student to Pay Fees
	 *@param student_id , Payment_Mode, RegCourse_id, Total_Amount
	 *@throws 
	 * */

	public void  pay_mode_detail(String cardno,String upi,String ex_date, int cvv,int studentid);
	/**
	 * Method for adding payment mode details(credit/debit card).
	 * @param Card_Number, Upi, Expiry_Date, CVV, StUdent_ID
	 */

	//public void ViewRegisterCourses(int stid) throws NotRegister;
	public List<Course> ViewRegisterCourses(int studentid) throws NotRegister;
	/**
	 * Method showing all courses which is register by student.
	 * @throws NotRegister
	 */
//	public void total_amount(int course_id, int total) ;

}