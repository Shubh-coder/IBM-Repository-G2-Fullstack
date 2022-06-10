/**
 * @author 003NRH744
 * Group 2 Members':
 * 1.Shubham Choudhary
 * 2.Nishant Chaudhari
 * 3.KirubaKaran
 * 4.Raghvedra
 * 5.Ravikumar Lakshatwar
 * 6.Penke Hemant Kumar
 * 
 */
package com.crs.ibm.application;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import com.crs.ibm.bean.Student;
import com.crs.ibm.dao.AdminDAO;
import com.crs.ibm.dao.AdminDAOInterface;
import com.crs.ibm.dao.UserDAO;
import com.crs.ibm.dao.UserDAOInterface;
import com.crs.ibm.exception.AlreadyRegister;
import com.crs.ibm.exception.UserNotExists;
import com.crs.ibm.service.*;

 
public class CRSApplication {

	// main Class of Application
	public static void main(String[] args) throws AlreadyRegister {
		/**
		 * Method show menu for the Application
		 * 
		 * @param user inputs  
		 * @throws
		 */
		AdminService adService = new AdminService();
		UserInterface user = new UserService();

		// main menu of the project Welcome to CRS Application\n
		// login New , Registration , Change password , Quit
    
		Scanner sc = new Scanner(System.in);
		System.out.println();
	 
	 
		while (true) {
			System.out.println(
					"Welcome to CRS Application\n 1.login\n" + " 2.New Registration\n 3.Change password\n 4.Quit ");
			int choice = sc.nextInt();
			switch (choice) {
			// Login
			case 1:
				user.login();
				 
				break;

				// New Registration for users
			case 2:

				String role = null;
				System.out.printf("Enter Details for registration:");
				System.out.println("enter  name:");
				String name = sc.next();

				System.out.println("Enter the mail id");
				String email = sc.next();
				System.out.println("choose your role");
				System.out.println("1.Student\n2.Professor\n3.Admin");
				int choices = sc.nextInt();
				if (choices == 1) {
					role = "Student";
				} else if (choices == 2) {
					role = "Professor";
				} else if (choices == 3) {
					role = "Admin";
				}
				System.out.println("enter the password");
				String pass1 = sc.next();
				System.out.println("enter the password again:");
				String pass2 = sc.next();
				if (pass1.equals(pass2)) {
					AdminDAOInterface register = new AdminDAO();
					register.registrationApproval(name, email, pass2, role);
					System.out.println("registered successfully");
				}
				break;

				// change password field 
			case 3:
				String role1 = null;
				System.out.println("Enter the mail id");
				String email1 = sc.next();
				System.out.println("choose your role");
				System.out.println("1.Student\n2.Professor\n3.Admin");
				int choices1 = sc.nextInt();
				if (choices1 == 1) {
					role1 = "Student";
				} else if (choices1 == 2) {
					role1 = "Professor";
				}
				try {
					adService.passwordReviewer(email1, role1);
				} catch (UserNotExists e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("password changed succesfully");

				break;

				// logout Session
			case 4:
				System.out.println("successfully logout");
				System.exit(0);
				break;

			}
		}
	}
}