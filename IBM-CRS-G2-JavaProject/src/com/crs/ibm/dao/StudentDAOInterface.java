package com.crs.ibm.dao;

import java.util.List;

import com.crs.ibm.bean.Course;
import com.crs.ibm.exception.CourseNotAdded;
import com.crs.ibm.exception.CourseNotFound;
import com.crs.ibm.exception.GradeNotAssigned;
import com.crs.ibm.exception.NotRegister;
import com.crs.ibm.exception.NotRemoved;

public interface StudentDAOInterface {


	public void AddCourse(String cn, int stid, int crsid) throws CourseNotAdded;
	/**
	 * Method for the student to add their desired course
	 * @param student_id and course_id
	 * @throws CourseNotFound
	 */
	public void DropCourse(int sid, int cid) throws NotRemoved;
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
	public void viewFees(int std) throws NotRegister;
	/**
	 * Method for student to view the total fee for their courses
	 * @param student_id
	 */
	public void ViewGrade(int studid) throws GradeNotAssigned;
	/**
	 * Method for student to view their grades
	 *@param srudent_id
	 *@throws GradeNotAssigned
	 * */
	public void Payment_fees(int std, String paymode);
	/**
	 * Method for student to Pay Fees
	 *@param student_id , Payment_Mode, RegCourse_id, Total_Amount
	 *@throws 
	 * */

	public void  pay_mode_detail(String cardno,String upi,String ex_date, int cvv,int stid);
	/**
	 * Method for adding payment mode details(credit/debit card).
	 * @param Card_Number, Upi, Expiry_Date, CVV, StUdent_ID
	 */

	//public void ViewRegisterCourses(int stid) throws NotRegister;
	public List<Course> ViewRegisterCourses(int stid) throws NotRegister;
	/**
	 * Method showing all courses which is register by student.
	 * @throws NotRegister
	 */
//	public void total_amount(int course_id, int total) ;

}