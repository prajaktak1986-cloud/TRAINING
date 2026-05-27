package com.msedcl.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.configuration.SpringConfiguration;
import com.msedcl.main.service.UserService;

public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Main Start");


AnnotationConfigApplicationContext annotationConfigApplicationContext 
= new AnnotationConfigApplicationContext(SpringConfiguration.class);

System.out.println("---------------");
UserService userService =
annotationConfigApplicationContext.getBean(UserService.class);

UserService userService2 =
annotationConfigApplicationContext.getBean(UserService.class);

System.out.println("---------------");
userService.createUser("Reema");

annotationConfigApplicationContext.close();


System.out.println("Main End");
	}

}
