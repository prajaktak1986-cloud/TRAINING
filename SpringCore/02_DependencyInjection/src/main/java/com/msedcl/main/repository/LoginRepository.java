package com.msedcl.main.repository;
import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import com.msedcl.main.domain.LoginDetails;

@Repository
public class LoginRepository {

	public LoginRepository() {
		// TODO Auto-generated constructor stub
		System.out.println("Default Constructor called - LoginRepository.");
	}
		
		private List<LoginDetails> loginDetailsList = new ArrayList<>();
		
		public boolean addNewUser(LoginDetails loginDetails) {
			System.out.println("addNewUser called from LoginRepository");
			return loginDetailsList.add(loginDetails);		
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
