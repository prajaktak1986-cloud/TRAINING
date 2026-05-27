package com.msedcl.main.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import com.msedcl.main.aspects.LoggingAspect;
import com.msedcl.main.service.UserService;

@Configuration
//@ComponentScan(basePackages = "com.msedcl.main")
@EnableAspectJAutoProxy
@Scope(scopeName="prototype")
public class SpringConfiguration {

	@Bean
	UserService getUserService() {
		System.out.println("SpringConfiguration class - getUserService()");
		return new UserService();
	}
	
	@Bean
	LoggingAspect getLoggingAspect() {
		System.out.println("SpringConfiguration class - getLoggingAspect()");
		return new LoggingAspect();
	}
}


//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//
//@Configuration
//@ComponentScan(basePackages = "com.msedcl.main")
//@EnableAspectJAutoProxy
//public class SpringConfiguration {
//
//}