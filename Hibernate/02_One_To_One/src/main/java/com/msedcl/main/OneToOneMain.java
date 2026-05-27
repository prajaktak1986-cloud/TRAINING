package com.msedcl.main;

import com.msedcl.main.entity.Address;
import com.msedcl.main.entity.User;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.TransactionManager;

public class OneToOneMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //select();
		//insert();
		//update();
		//merge();
		//remove();
		//detach();
		refresh();
	}
	
	public static void refresh() {
		// Object loaded in Java - from DB
		// Object may be updated externally - from DB
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction  entityTransaction = entityManager.getTransaction();		
		entityTransaction.begin();
		// Object fetch -  Persistent
		User existingUser = entityManager.find(User.class, 4);
		System.out.println(existingUser);
		
		existingUser.setName("Rohit Sharma");
		existingUser.getAddress().setCity("Kochi");
		
		System.out.println("After changes");
		System.out.println(existingUser);
		
		System.out.println("Refresh Called");
		entityManager.refresh(existingUser);
		
		entityTransaction.commit();
		entityManager.close();
		
		System.out.println("After Refresh");
		System.out.println(existingUser);
	}
	
	public static void detach() {
		// detach = Remove entity from persistence context
		// which means hibernate stops tracking object changes
		
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction  entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		// Object fetch -  Persistent
		User existingUser = entityManager.find(User.class, 4);
		System.out.println("Before detach");
		System.out.println(existingUser);
		
		entityManager.detach(existingUser);//Detach
		
		existingUser.setName("Rahul MEHETA");
		existingUser.getAddress().setCity("UJJAIN");
		
		 entityTransaction.commit();
		 entityManager.close();
		 System.out.println("after changes into detached object");
		 System.out.println(existingUser);
		 System.out.println("Check your table");
		
	}
	public static void remove() {
		EntityManager entityManager = HibernateUtil.getEntityManager();//Transient
		User existingUser = entityManager.find(User.class, 2);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.remove(existingUser);
		entityTransaction.commit();
		entityManager.close();
		
		
	}
	public static void merge() {
		EntityManager entityManager = HibernateUtil.getEntityManager();//Transient
		User existingUser = entityManager.find(User.class, 2);
		
		Address address1 = new Address(2, "Karad", "789654");
		
		System.out.println("Object fetched");
		System.out.println(existingUser);
		
		entityManager.close();
		System.out.println("Entity manager closed.");
		
		//at this point existingUser is in detached state
		
		existingUser.setName("Senha Ranade");
		existingUser.setAddress(address1);
		System.out.println("Modified Detahced Object.");
		System.out.println(existingUser);
		
		entityManager= HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		//entityManager.persist(existingUser);
		entityManager.merge(existingUser);
		entityTransaction.commit();
		entityManager.close();
		
		
		System.out.println("Check your table");
	}
	
	public static void update() {
		EntityManager entityManager = HibernateUtil.getEntityManager();//Transient
		User user = entityManager.find(User.class, 4);
		
	
//		User user1  = new User(0, "Tina", address);
		
		if(user != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Address address = new Address(0, "Pune", "420012");
			//entityManager.merge(user1);
			user.setName("Neha Rao");
			user.setAddress(address);
			entityManager.persist(user);
			entityTransaction.commit();
			System.out.println("User Updated successfully");
			}
			else
				System.out.println("Invalid Employee");	
			
			entityManager.close();
		
	}
	
	public static void insert() {
		Address address = new Address(0, "Mumbai", "400071");
		User user  = new User(0, "Rahul", address);
		
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		entityManager.close();
		
		
	}
	
	public static void select() {
		
		EntityManager entityManager = HibernateUtil.getEntityManager();
		User user = entityManager.find(User.class, 1);
		//System.out.println(user);
		System.out.println(user.getName() + " " + user.getAddress().getCity());
		entityManager.close();
		
	}

}
