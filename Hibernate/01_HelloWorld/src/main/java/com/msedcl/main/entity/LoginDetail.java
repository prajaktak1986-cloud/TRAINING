package com.msedcl.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="login_details")
public class LoginDetail {
	
	@Id	
	@Column(name="login_id")
	private int loginId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="invalid_login_count")
	private int invalidLoginCount;
	
	@Column(name="max_count")
	private int maxCount;
	
	@Column(name="Status")
	private String Status;
	
	public LoginDetail() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LoginDetail [loginId=" + loginId + ", password=" + password + ", invalidLoginCount=" + invalidLoginCount
				+ ", maxCount=" + maxCount + ", Status=" + Status + "]";
	}

	public LoginDetail(int loginId, String password, int invalidLoginCount, int maxCount, String status) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.invalidLoginCount = invalidLoginCount;
		this.maxCount = maxCount;
		Status = status;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getInvalidLoginCount() {
		return invalidLoginCount;
	}

	public void setInvalidLoginCount(int invalidLoginCount) {
		this.invalidLoginCount = invalidLoginCount;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
}
