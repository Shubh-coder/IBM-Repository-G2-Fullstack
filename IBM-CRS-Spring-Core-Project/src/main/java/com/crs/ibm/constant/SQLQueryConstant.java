/**
 * 
 */
package com.crs.ibm.constant;

/**
 * @author 003NRH744
 *
 */
public class SQLQueryConstant {
	//Admin Queries
	public static final String REGISTRATION_USER="insert into user(Name,Email,Password,Role,approval)values(?,?,?,?,0)";
	public static final String LOGIN_TRACKER="insert into loginSession(User_Name,User_Role,Login_DateTime)values(?,?,?)";

	//	public static final String AUTHENTICATE_USER="select * from user where Email='" + email + "' && Password='" + password+ "' ";
	public static final String ADD_COURSE_ADMIN="insert into course(id,course_name,course_section,course_type,max_student,course_price,course_duration,professor_id) values(?,?,?,?,?,?,?,?)";
	public static final String DELETE_COURSE_ADMIN="delete from course where id=?";
	public static final String APPROVAL="update user set approval=1 where email=?";
	public static final String VIEW_NOTAPPROVE_USERS="Select * from user where approval=0";

	// Student Queries
	public static final String VIEW_COURSE_STUDENT="Select * from course";
	public static final String ADD_COURSE_STUDENT="insert into course_reg (course_name,student_id,course_id) values(?,?,?)";
	public static final String DROP_COURSE_STUDENT="Delete from course_reg where Student_id=? && Course_id=?";
	public static final String VIEW_REGISTER_COURSES_STUDENT="select * from course inner join course_reg on course.id = course_reg.course_id where course_reg.student_id = ?"; 
 

	public static final String VIEW_STUDENT_PROFESSOR="Select * from student";
	public static final String ADD_GRADE_PROFESSOR="Update student SET grade=? where id=?";
	public static final String ASSIGN_PROFESSOR = "Update course SET Professor_Id=? where Id=?";
	public static final String ALL_COURSES = "select * from course";
	public static final String CHANGE_PASSWORD = "update user SET password=? where email=?";
//	public static final String COURSE_FEES = "select Id,course_price from course where id=(select course_id from course_reg where student_id=?)";
	public static final String STUDENT_TOTAL_AMOUNT = "select  SUM(course.course_price) from course inner join course_reg on course.id = course_reg.course_id where course_reg.student_id = ?";
	public static final String COURSE_F="select * from course inner join course_reg on course.id = course_reg.course_id where course_reg.student_id = ?";
	public static final String INSERT_STUDENT_DETAIL="insert into student(Name,Qualification,Branch,Contact,Address)values(?,?,?,?,?)";


	public static final String INSERT_PAYMENT="insert into payment_fees(student_id,Payment_Method,RegCourse_Id,Total_Amount)values(?,?,?,?)";
	public static final String INSERT_PAYMENT_MODE_DETAIL="insert into payment_mode_detail(Card_Number,Upi_Number,Expiry_Date,Cvv,Student_Id)values(?,?,?,?,?)";
}
