package com.crs.ibm.application;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.crs.ibm.configuration.ApplicationConfig;
import com.crs.ibm.dao.AdminDAO;
import com.crs.ibm.dao.AdminDAOInterface;
import com.crs.ibm.exception.*;
import com.crs.ibm.service.AdminInterface;
import com.crs.ibm.service.StudentInterface;
import com.crs.ibm.service.UserInterface;

 

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@Import((ApplicationConfig.class))
public class IbmCrsSpringCoreProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(ApplicationConfig.class);
		
		UserInterface user= (UserInterface) context.getBean("userBean");
		StudentInterface stud= (StudentInterface) context.getBean("studentBean");
		AdminInterface ad= (AdminInterface) context.getBean("adminBean");
		
		
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
					try {
						register.registrationApproval(name, email, pass2, role);
					} catch (AlreadyRegister e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
					ad.passwordReviewer(email1, role1);
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
