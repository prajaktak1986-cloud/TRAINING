package com.msedcl.main.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import com.msedcl.main.domain.LoginDetails;
import com.msedcl.main.repository.LoginRepository;

@Service
public class LoginService {
	
	
	private LoginRepository loginRepository;
	
//	public LoginService() {
//		System.out.println("Default Constructor called - LoginService.");
//	}

	
	public LoginService(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
		System.out.println("Overloaded Constructor called - LoginService.");
	}

	public LoginRepository getLoginRepository() {
		System.out.println("getLoginRepository");
		return loginRepository;
	}

	
	public void setLoginRepository(LoginRepository loginRepository) {
		System.out.println("setLoginRepository");
		this.loginRepository = loginRepository;
	}

	public boolean validateLoginDetails(LoginDetails loginDetails) {
		System.out.println("validateLoginDetails called from LoginService");
		return loginRepository.validateLoginDetails(loginDetails);
	}
	
	public boolean addNewUser(LoginDetails loginDetails) {
		System.out.println("addNewUser called from LoginService");
		return loginRepository.addNewUser(loginDetails);
	}

	 
}
