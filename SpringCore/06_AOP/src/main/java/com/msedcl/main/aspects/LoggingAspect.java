package com.msedcl.main.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
public class LoggingAspect {

	@Pointcut("execution(void com.msedcl.main.service.UserService.createUser(String))")
	public void logging() {
		
	}
	
	//@Before("execution(* com.msedcl.main.service.*.*(..)")	
	//@Before("execution(void com.msedcl.main.service.UserService.createUser(String))")
	@Before("logging()")	
	public void logBefore(JoinPoint joinPoint ) {
		System.out.println("[Before] advice called for method :: "
				+joinPoint.getSignature().getName());
	}
	
	@Around("logging()")
	public void logBefore(ProceedingJoinPoint proceedingJoinPoint ) throws Throwable {
		System.out.println("[Around] advice called before method execution:: ");
		
		//call actual function
		System.out.println("proceedingJoinPoint.proceed()");
		proceedingJoinPoint.proceed();
		
		System.out.println("[Around] advice called after method execution:: ");
		
		
	}

	//@After("execution(void com.msedcl.main.service.UserService.createUser(String))")
	@After("logging()")
	public void logAfter() {
		System.out.println("[After] advice called.");
	}

}
