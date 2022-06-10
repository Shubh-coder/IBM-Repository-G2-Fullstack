package com.crs.ibm.service;
import com.crs.ibm.bean.*;
import com.crs.ibm.dao.StudentDAO;
import com.crs.ibm.dao.StudentDAOInterface;
import com.crs.ibm.dao.UserDAO;
import com.crs.ibm.dao.UserDAOInterface;
import com.crs.ibm.exception.CourseNotAdded;
import com.crs.ibm.exception.CourseNotFound;
import com.crs.ibm.exception.GradeNotAssigned;
import com.crs.ibm.exception.NotRegister;
import com.crs.ibm.exception.NotRemoved;

import java.sql.SQLException;
import java.util.*;

public class StudentService implements StudentInterface {
	StudentDAOInterface stdo= new StudentDAO();
	UserDAOInterface urs = new UserDAO();
	/**
	 * Method for the student to add their desired course
	 * @param student_id and course_id
	 * @throws CourseNotFound
	 */
	public void AddCourse(String cn, int stid, int crsid) throws CourseNotAdded,InputMismatchException{
		try {
			stdo.AddCourse(cn, stid, crsid);
		}catch(CourseNotAdded | InputMismatchException e) {
			throw e;
		}
	}
	/**
	 * Method for student to remove the course
	 * @param student_id and course_id
	 * @throws NotRemoved
	 */
	public void DropCourse(int sid, int cid) throws NotRemoved {
		// TODO Auto-generated method stub
		try {
			stdo.DropCourse(sid, cid);
		}catch(NotRemoved e) {
			throw e;
		}
	}
	/**
	 * Method to see the course before registering the course
	 */
	public void CourseRegistration() throws NotRegister {
		// TODO Auto-generated method stub
		try {
			stdo.CourseRegistration();
		}catch(NotRegister e){
			throw e;
		}

	}
	/**
	 * Method for student to view the total fee for their courses
	 * @param student_id
	 */
	public void viewFees(int std) throws NotRegister {
		// TODO Auto-generated method stub
		try {
			stdo.viewFees(std);
		}catch(NotRegister e) {
			throw e;
		}
	}

	/**
	 * Method for student to view their grades
	 *@param srudent_id
	 * @throws Exception 
	 *@throws GradeNotAssigned
	 * */
	public void ViewGrade(int studid) throws GradeNotAssigned {
		// TODO Auto-generated method stub
		try {
			stdo.ViewGrade(studid);
		}catch(GradeNotAssigned e) {
			throw e;
		}

	}

	/**
	 * Method for student to Pay Fees
	 *@param srudent_id , Payment_Mode, RegCourse_id, Total_Amount
	 *@throws Exception
	 * */
	public void Payment_fees(int stid, String paymode) throws Exception{
		try {
			stdo.Payment_fees(stid, paymode);
		}catch(Exception se)
		{
			System.out.println(se.getMessage());
		}
	}

	/**
	 * Method for getting student details from student and tore in database
	 *@param Student_Name, Qualification, Branch, Contact_Number, Address
	 *
	 * */

	public void StudentDetail(String name,String quali,String branch,String contact,String address)
	{
		try {
			urs.StudentDetail(name, quali, branch, contact, address);
		}catch(Exception se)
		{
			System.out.println(se.getMessage());
		}
	}

	/**
	 * Method for adding payment mode details(credit/debit card).
	 * @param Card_Number, Upi, Expiry_Date, CVV, StUdent_ID
	 */

	public void  pay_mode_detail(String cardno,String upi,String ex_date, int cvv,int stid)
	{
		try {
			stdo.pay_mode_detail(cardno, upi, ex_date, cvv, stid);	

		}catch(Exception se)
		{
			System.out.println(se.getMessage());
		}

	}


	/**
	 * Method showing all courses which is register by student.
	 * @throws NotRegister
	 */
	public void ViewRegisterCourses(int stid) throws NotRegister
	{
		try {
			stdo.ViewRegisterCourses(stid);
		}catch(Exception se)
		{
			System.out.println(se.getMessage());
		}

	}
}