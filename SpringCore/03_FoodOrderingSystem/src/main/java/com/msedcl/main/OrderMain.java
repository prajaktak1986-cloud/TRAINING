package com.msedcl.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.msedcl.main.service.OrderService;

public class OrderMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				"com.msedcl.main");//creates object of LoginRepository and then LoginService
		
		System.out.println("------------------------");

	

		// Inject LoginService object from Spring
		//LoginService loginService = applicationContext.getBean(LoginService.class);.
		
       OrderService orderService =  applicationContext.getBean(OrderService.class);
       
		System.out.println("From Main calling OrderService");
		 orderService.billCalculate();
		
		System.out.println();
		
		
		
	}

}
