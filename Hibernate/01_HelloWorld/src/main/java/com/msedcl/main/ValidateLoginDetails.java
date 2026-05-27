package com.msedcl.main;

import java.util.Scanner;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.entity.LoginDetail;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ValidateLoginDetails {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LoginDetail loginDetail = new LoginDetail();
		int loginId = 0;
		String password;
		String userStatus;
		
		System.out.println("Enter Login Id");
		loginId = scanner.nextInt();
		loginDetail = validateLoginid(loginId);
		
		if(loginDetail != null)
			System.out.println(loginDetail);
		loginId = loginDetail.getLoginId();
        userStatus = loginDetail.getStatus(); 
       if( loginId != 0 && userStatus.equals("active")) {
    	   System.out.println("Enter Password Id");
   		password = scanner.next();
   		validateLoginUser(loginId,password);
		}
       if( loginId != 0 && userStatus.equals("blocked")) {
    	   System.out.println("User blocked contact admin");
       }
	  else 
			System.out.println("Invalid loginId");
		
		
		
	}
	
public static LoginDetail validateLoginid(int loginId) {
		
		//1. Create EntityManager object		
		EntityManager entityManager = HibernateUtil.getEntityManager();
		
		//2. Get Employee from database
		LoginDetail loginDetail = entityManager.find(LoginDetail.class, loginId);
//		if(loginDetail != null)
//			System.out.println(loginDetail);
//		else 
//			System.out.println("Invalid loginId");
		
		entityManager.close();
		return loginDetail;
		
	}

public static void validateLoginUser(int loginId, String password) {
	int cnt =3; 
	int cnt1 =0;
	Scanner scanner = new Scanner(System.in);
	//1. Create EntityManager object		
	EntityManager entityManager = HibernateUtil.getEntityManager();
	
	//2. Get Employee from database
	LoginDetail loginDetail = entityManager.find(LoginDetail.class, loginId);
	if(!loginDetail.getPassword().equals(password)) {
	do {
	  cnt = loginDetail.getMaxCount();
	  cnt1 =loginDetail.getInvalidLoginCount();
	  //System.out.println("--inside validateLoginUser if password is incorrect---" + loginId + cnt+ cnt1);
	  System.out.println("--inside validateLoginUser if password is incorrect---" + loginId + "--" +loginDetail.getMaxCount()+ "--" + loginDetail.getInvalidLoginCount());
		System.out.println("Invalid password, " + loginDetail.getMaxCount() + "attempt left.!");
		
		updateEmployeeLogin(loginId, cnt, cnt1);
	 
		System.out.println("Enter password:: ");
	  password = scanner.next();
  } while(loginDetail.getMaxCount() > 1);   //while(cnt>1);
	 }
 if(cnt ==0) {
	//if(loginDetail.getMaxCount() == 0) {
	  System.out.println("Invalid password account blocked!! ");
	  blockLoginId(loginId);
  }
  if(loginDetail.getPassword().equals(password)) {
	  System.out.println("Login successfully!!! ");
  }
	entityManager.close();
	
	
}

public static void updateEmployeeLogin(int loginId, int cnt, int cnt1) {
	//1. Create EntityManager object
	System.out.println("--inside updateEmployeeLogin---" + loginId + cnt+ cnt1);
	
	EntityManager entityManager = HibernateUtil.getEntityManager();//Transient
	LoginDetail existingLoginDetail = entityManager.find(LoginDetail.class, loginId);
	
	if(existingLoginDetail != null) {
	EntityTransaction entityTransaction = entityManager.getTransaction();
	entityTransaction.begin();
existingLoginDetail.setInvalidLoginCount(cnt1);
	existingLoginDetail.setMaxCount(cnt);
	//entityManager.merge(employee);
	entityTransaction.commit();
	System.out.println("Login count Updated successfully");
	}
	else
		System.out.println("Invalid Login!!!");	
	
	entityManager.close();
}

public static void blockLoginId(int loginId) {
	//1. Create EntityManager object
	System.out.println("--inside blockLoginId---" + loginId );
	
	EntityManager entityManager = HibernateUtil.getEntityManager();//Transient
	LoginDetail existingLoginDetail = entityManager.find(LoginDetail.class, loginId);
	
	if(existingLoginDetail != null) {
	EntityTransaction entityTransaction = entityManager.getTransaction();
	entityTransaction.begin();
existingLoginDetail.setStatus("blocked");
	
	entityTransaction.commit();
	System.out.println("Invalid Password, Account blocked!!!");
	}
//	else
//		System.out.println("Invalid Login!!!");	
	
	entityManager.close();
}

}
