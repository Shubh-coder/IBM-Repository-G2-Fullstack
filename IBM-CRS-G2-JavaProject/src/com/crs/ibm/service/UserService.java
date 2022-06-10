package com.crs.ibm.service;
import com.crs.ibm.application.CRSApplication;
import com.crs.ibm.dao.*;
import com.crs.ibm.exception.AlreadyRegister;
import com.crs.ibm.exception.CourseNotAdded;
import com.crs.ibm.exception.GradeNotAssigned;
import com.crs.ibm.exception.NoDataFound;
import com.crs.ibm.exception.NotRegister;
import com.crs.ibm.exception.NotRemoved;
import com.crs.ibm.exception.ProfessorNotAssigned;
import com.crs.ibm.exception.UserNotApproved;
import com.crs.ibm.exception.UserNotExists;
import com.crs.ibm.service.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class UserService implements UserInterface {
 
	Scanner sc=new Scanner(System.in);
	AdminService adService = new AdminService();
	StudentService studService = new StudentService();
	ProfessorService profService = new ProfessorService();
	CRSApplication obj=new CRSApplication();
	ArrayList<String> CourseList = new ArrayList<String>(); // Create an ArrayList object
	ProfessorDAOInterface pr= new ProfessorDAO();
	StudentDAOInterface sd = new StudentDAO();
	AdminDAOInterface ad = new AdminDAO();
	UserDAOInterface usdo = new UserDAO();
	
	/**
	 * Regex to check valid password.
	 * 
	 * @param password
	 */	
	 static boolean isValidPassword(String password)
    {
  
        
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
  
          
        Pattern p = Pattern.compile(regex);
  
         
        if (password == null) {
            return false;
        }
  
         
        Matcher m = p.matcher(password);
  
         
        return m.matches();
    }

	public void  login()
	{

		boolean choices ;
		System.out.println("Enter the email:");
		String email = sc.next();
		System.out.println("Enter the password:");
		String pswd = sc.next();
		
//		choices = Arrays.asList(pswd).stream().map(x -> isValidPassword(pswd)).forEach(System.out::println);
		 

		try {
			ad.authenticateUser(email, pswd);
		} catch (UserNotApproved e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private String println(Object forEach) {
		// TODO Auto-generated method stub
		return null;
	}
 

	public void UserSelection(String user) {
		int n=0;
		if (user.equals("Student")) {
			n=1;
		}else if(user.equals("Professor")) {
			n=2;
		}else {
			n=3;
		}
		if (n == 1) {
			user = "Student";
			 
			while(true) {	 
					
			    
			    System.out.println("\n");
				System.out.println("1.Enter your detail \n2.View available courses. \n3.Add course \n4.View register course \n5.Drop course \n6.Pay fee \n7.Logout");
				int n1=sc.nextInt();

				if(n1==1)
				{
					System.out.println("Please Enter Your Details");
					System.out.println("Enter Name:");
					String name=sc.next();
					System.out.println("Enter Qualification:");
					String qual=sc.next();
					System.out.println("Enter Branch:");
					String branch=sc.next();
					System.out.println("Enter Contact.No:");
					String contact=sc.next();
					System.out.println("Enter Address:");
					String address=sc.next();
					studService.StudentDetail(name, qual, branch, contact,address);
				}
				else if(n1==2)
				{
					try {
						sd.CourseRegistration();
					} catch (NotRegister e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				else if(n1==3)
				{
					//Student can add course

					System.out.println("Student can add the course");
					System.out.println("Enter the number of course you add");
					int si=sc.nextInt();

					String cn = null;
					int stid,crsid;
					System.out.println("Enter the StudentID:");
					stid=sc.nextInt();
					System.out.println("Enter the courseID:");
					crsid=sc.nextInt();

					for(int i=0;i<si;i++)
					{
						System.out.println("Enter the course name:");
						cn=sc.next();

						try {
							sd.AddCourse(cn,stid,crsid);
						} catch (CourseNotAdded e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} 


					//						  studService.AddCourse();
					System.out.println("1.if you want to continue \n 2. drop course 3 Student Menu");
					System.out.println("Enter choice number");
					int n11=sc.nextInt();
					if(n11==1)
					{
						try {
							sd.AddCourse(cn,stid,crsid);
						} catch (CourseNotAdded e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(n11==2)
					{

						System.out.println("enter Id to drop the course");
						int cid=sc.nextInt();
						System.out.println("enter your Student Id ");
						int sid=sc.nextInt();
						try {
							sd.DropCourse(sid,cid);
						} catch (NotRemoved e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else if(n11==3)
					{
						StudentMenu();
					}

				}
				else if(n1==4)
				{
					System.out.println("Enter your studentId for register course details");
					int stid=sc.nextInt();
					try {
						studService.ViewRegisterCourses(stid);
					} catch (NotRegister e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	  
				else if(n1==5)
				{
					System.out.println("enter Id to drop the course");
					int cid=sc.nextInt();
					System.out.println("enter your Student Id ");
					int sid=sc.nextInt();
					try {
						sd.DropCourse(sid,cid);
					} catch (NotRemoved e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("1.Go to Student menu ");
					int n31=sc.nextInt();
					if(n31==1)
					{
						StudentMenu();
					}
				}
				else if(n1==6)
				{		
					String paymode=null;
					System.out.println("enter ur Student ID:=");
					int stid=sc.nextInt();
					try {
						studService.viewFees(stid);
					} catch (NotRegister e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Choose the payment mode:");
					System.out.println("1.Credit card\n2.Debit card \n3.UPI \n4.Cash ");
					int choice= sc.nextInt();
					String cardno=null;
					String upi=null;
					String ex_date=null;
					int cvv=0;


					switch(choice) {
					case 1:
						paymode="Credit card";
						System.out.println("Enter Card Number:");
						cardno=sc.next();
						System.out.println(" Enter Card Expiry Date(mm/yy):");
						ex_date=sc.next();
						System.out.println("Enter CVV ");
						cvv=sc.nextInt();
						studService.pay_mode_detail(cardno,upi,ex_date,cvv,stid);
						break;	  
					case 2:

						paymode = "Debit Card";
						System.out.println("Enter Card Number:");
						cardno=sc.next();
						System.out.println(" Enter Card Expiry Date(mm/yy):");
						ex_date=sc.next();
						System.out.println("Enter CVV ");
						cvv=sc.nextInt();
						studService.pay_mode_detail(cardno,upi,ex_date,cvv,stid);
						break;
					case 3:
						paymode = "UPI";
						System.out.println("Enter Upi ID");
						upi=sc.next();
						studService.pay_mode_detail(cardno, upi, ex_date, cvv, stid);
						break;
					case 4:
						paymode = "Cash";
						break;
					}


					try {
						studService.Payment_fees(stid,paymode);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(n1==7)
				{						 
					try {
						CRSApplication.main(null);
					} catch (AlreadyRegister e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}

			}	  


		}else if(n==2)
		{
			user="professor";
			System.out.println(ad.displayCurrentDate());
			while(true) {
				
				System.out.println("1.View Student List.\n2Add Grade \n3.ProfessorMenu \n4.Logout");
				int a=sc.nextInt();

				if(a==1) {
					try {
						pr.getEnrolledStudent();
					} catch (NoDataFound e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//profService.ViewEnrollStudent();
				}else if(a==2)
				{
					System.out.println("Select Id of Student to add Grades");
					int id = sc.nextInt();

					System.out.println("enter grade:");
					String gd = sc.next();
					try {
						pr.addGrade( id, gd);
					} catch (GradeNotAssigned | UserNotExists e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//  profService.AddGrades();
				}
				else if(a==3)
				{
					ProfessorMenu();
				}
				else if(a==4)
				{
					try {
						CRSApplication.main(null);
					} catch (AlreadyRegister e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}	
		} else if (n==3) {
			user= "admin";
			while (true) {
				System.out.println(ad.displayCurrentDate());
				
				System.out.println("\n1.Add course\n2.Remove course"
						+ "  card\n3.Add professor\n4.Aprove Registration \n5. View CourseList \n6.Generate report \n7 Logout");
				int choice = sc.nextInt();
				switch(choice) {
				case 1:
					System.out.println("ENTER DETAILS OF COURSE");	 
					System.out.println("Enter Couse Id");
					int csid=sc.nextInt();
					System.out.println("Enter Course name");
					String csname=sc.next();
					System.out.println("Enter Course section");
					String cssec=sc.next();
					System.out.println("Enter Course Type");
					String cstype=sc.next();
					System.out.println("Enter Max Student allow to course");
					int csmax=sc.nextInt();
					System.out.println("Enter Course Price");
					double csprice=sc.nextDouble();
					System.out.println("Enter Number of months for course duration");
					int csdur=sc.nextInt();
					System.out.println("Enter Professsor Id");
					int csprid=sc.nextInt();
					System.out.println("");
					try {
						ad.addCourse(csid,csname,cssec,cstype,csmax,csprice,csdur,csprid);
					} catch (CourseNotAdded e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					break;
				case 2:
					System.out.println("please Enter ID to Delete Course");
					int deid;
					deid=sc.nextInt();
					try {
						ad.deleteCourse(deid);
					} catch (NotRemoved e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				case 3:
					try {
						adService.assignProfessorFOrCourse();
					} catch (ProfessorNotAssigned e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 4:
					usdo.allUser();
					System.out.println("Enter the email id of the user for approval:");
					String usr_email = sc.next();
					ad.approveStudent(usr_email);
					break;
				case 5:
					try {
						adService.showAllCourses();
					} catch (NoDataFound e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 6:
					System.out.println("Report card generation");
					break;
				case 7:
					try {
						CRSApplication.main(null);
					} catch (AlreadyRegister e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;		

				}

			}
		}


		//we can use to define Student registration process
	}

	public void StudentMenu()
	{
		System.out.println(ad.displayCurrentDate());
		System.out.println("1 Update your details \n2.CourseRegistration. \n3.Add Course  \n4.View register courses \n5.Drop Course \n6.Pay Fee \n7.Logout");
		int n1=sc.nextInt();
		while(true) {
			if(n1==1)
			{

			}
			else if(n1==2)
			{
				try {
					sd.CourseRegistration();
				} catch (NotRegister e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// studService.CourseRegistration();
			}
			else if(n1==3)
			{
				System.out.println("\n1.if you want to continue \n 2. drop course 3 Student Menu");
				System.out.println("Enter choice number");
				int n11=sc.nextInt();
				if(n11==1)
				{ System.out.println("Student can Add the Course");
				System.out.println("Enter the number of Course you Add");
				int si=sc.nextInt();

				String cn = null;
				int stid,crsid;
				System.out.println("Enter the Student ID:");
				stid=sc.nextInt();
				System.out.println("Enter the course ID:");
				crsid=sc.nextInt();

				for(int i=0;i<si;i++)
				{
					System.out.println("Enter the course Name:");
					cn=sc.next();

					try {
						studService.AddCourse(cn, stid, crsid);
					} catch (CourseNotAdded e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}
				else if(n11==2)
				{ System.out.println("enter Id to drop the course");
				int cid=sc.nextInt();
				System.out.println("enter your Student Id ");
				int sid=sc.nextInt();
				try {
					studService.DropCourse(sid, cid);
				} catch (NotRemoved e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				}else if(n11==3)
				{
					StudentMenu();
				}
			}
			else if(n1==4)
			{
				System.out.println("Enter your studentId for register course details");
				int stid=sc.nextInt();
				try {
					studService.ViewRegisterCourses(stid);
				} catch (NotRegister e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	  
			else if(n1==5)
			{
				System.out.println("enter Id to drop the course");
				int cid=sc.nextInt();
				System.out.println("enter your Student Id ");
				int sid=sc.nextInt();
				try {
					studService.DropCourse(sid, cid);
				} catch (NotRemoved e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("1.Go to Student menu ");
				int n31=sc.nextInt();
				if(n31==1)
				{
					StudentMenu();
				}
			}

			else if(n1==6)
			{ System.out.println("enter ur Student ID:=");
			int std=sc.nextInt();
			try {
				studService.viewFees(std);
			} catch (NotRegister e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else if(n1==7)
			{						 
				try {
					CRSApplication.main(null);
				} catch (AlreadyRegister e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
	}

	public void ProfessorMenu()
	{
		while(true) {
			System.out.println("\n1.View Student List.\n2Add Grade \n3.ProfessorMenu");
			int a=sc.nextInt();

			if(a==1) {
				try {
					profService.getEnrolledStudent();
				} catch (NoDataFound e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(a==2)
			{System.out.println("Select Id of Student to add Grades");
			int id = sc.nextInt();

			System.out.println("enter grade:");
			String gd = sc.next();
			try {
				profService.addGrade(id, gd);
			} catch (GradeNotAssigned e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotExists e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			}
			else if(a==3)
			{
				ProfessorMenu();
			}
		} 
	}
}