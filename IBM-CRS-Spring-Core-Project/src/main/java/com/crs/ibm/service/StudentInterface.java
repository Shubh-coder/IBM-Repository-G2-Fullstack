package com.crs.ibm.service;

import java.sql.SQLException;

import com.crs.ibm.exception.CourseNotAdded;
import com.crs.ibm.exception.CourseNotFound;
import com.crs.ibm.exception.GradeNotAssigned;
import com.crs.ibm.exception.NotRegister;
import com.crs.ibm.exception.NotRemoved;

public interface StudentInterface {


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
	 * @throws NotRemoved
	 */

	public void CourseRegistration()throws NotRegister;
	/**
	 * Method to see the course before adding 
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
	 * @throws Exception 
	 *@throws GradeNotAssigned
	 * */
	public void Payment_fees(int stid, String paymode) throws Exception;
	/**
	 * Method for student to Pay Fees
	 *@param srudent_id , Payment_Mode, RegCourse_id, Total_Amount
	 *@throws 
	 * */
	public void StudentDetail(String name,String quali,String branch,String contact,String address);

	/**
	 * Method for inserting all details of student
	 * @param name, qualification, branch, contact, address
	 * @exception UserNotExists
	 */


	public void  pay_mode_detail(String cardno,String upi,String ex_date, int cvv,int stid);
	/**
	 * Method for adding payment mode details(credit/debit card).
	 * @param Card_Number, Upi, Expiry_Date, CVV, StUdent_ID
	 */
	public void ViewRegisterCourses(int stid) throws NotRegister;
	/**
	 * Method showing all courses which is register by student.
	 * @throws NotRegister
	 */
}
