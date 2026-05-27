package com.msedcl.main;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.domain.LoginDetails;
import com.msedcl.main.service.LoginService;

public class LoginMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//       Scanner scanner = new Scanner(System.in);
//       System.out.println("Enter Login Id.");
//       String loginId= scanner.next();
//       System.out.println("Enter Password.");
//       String password= scanner.next();
//       
//       LoginDetails loginDetails = new LoginDetails(loginId, password);
//       
//      // LoginService loginService = new LoginService();
//       // Spring Container
//       AnnotationConfigApplicationContext annotationConfigApplicationContext =
//    		   new AnnotationConfigApplicationContext("com.msedcl.main.service");
//       System.out.println("----------------------------");
//       LoginService loginService =annotationConfigApplicationContext.getBean(LoginService.class);
//       
//       LoginService loginService1 =annotationConfigApplicationContext.getBean(LoginService.class);
//       if (loginService.validateLoginDetails(loginDetails)) {
//			System.out.println("Login Successfull");
//		} else {
//			System.out.println("Login Failed!!");
//		}
//		scanner.close();
//		annotationConfigApplicationContext.close();

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				"com.msedcl.main");//creates object of LoginRepository and then LoginService
		boolean status;
		System.out.println("------------------------");

		// 1. Add 3 users into database
		LoginDetails user1 = new LoginDetails("ADMIN", "Admin@123");
		LoginDetails user2 = new LoginDetails("USER", "User@123");
		LoginDetails user3 = new LoginDetails("POWERUSER", "PowerUser@123");

		// Inject LoginService object from Spring
		LoginService loginService = applicationContext.getBean(LoginService.class);

		System.out.println("Adding First User");
		status = loginService.addNewUser(user1);
		System.out.println("Status = " + status);
		System.out.println();
		System.out.println("Adding Second User");
		status = loginService.addNewUser(user2);
		System.out.println("Status = " + status);
		System.out.println();
		System.out.println("Adding Third User");
		status = loginService.addNewUser(user3);
		System.out.println("Status = " + status);
		System.out.println();
		
		// 2. Validate only single user
	}

}
