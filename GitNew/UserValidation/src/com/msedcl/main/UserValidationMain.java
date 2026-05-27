package com.msedcl.main;

import com.msedcl.util.UserValidationUtil;

public class UserValidationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   System.out.println("User validation.");
   UserValidationUtil userVal = new UserValidationUtil();
   System.out.println("called UserValidationUtil.");
   userVal.ValidatePhoneNumber();
	}

}
