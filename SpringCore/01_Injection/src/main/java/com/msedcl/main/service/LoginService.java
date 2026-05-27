package com.msedcl.main.service;

import java.security.PublicKey;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.msedcl.main.domain.LoginDetails;

@Component
@Scope(scopeName = "prototype")
public class LoginService {
	
	public LoginService() {
		System.out.println("Default Constructor created.");
	}

	public boolean validateLoginDetails(LoginDetails loginDetails) {
		
		if(loginDetails.getLoginId().equals("ADMIN")
			&& loginDetails.getPassword().equals("Admin@123")	
		  )
			return true;
		else
		return false;
		
		
	}
}
