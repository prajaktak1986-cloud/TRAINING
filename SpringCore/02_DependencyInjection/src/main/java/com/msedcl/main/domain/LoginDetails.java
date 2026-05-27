package com.msedcl.main.domain;

public class LoginDetails {
     private String LoginId;
     private String password;
     
     public LoginDetails() {
		// TODO Auto-generated constructor stub
	}

	 public LoginDetails(String loginId, String password) {
		super();
		LoginId = loginId;
		this.password = password;
	 }

	 @Override
	 public String toString() {
		return "LoginDetails [LoginId=" + LoginId + ", password=" + password + "]";
	 }

	 public String getLoginId() {
		 return LoginId;
	 }

	 public void setLoginId(String loginId) {
		 LoginId = loginId;
	 }

	 public String getPassword() {
		 return password;
	 }

	 public void setPassword(String password) {
		 this.password = password;
	 }
     
     
}
