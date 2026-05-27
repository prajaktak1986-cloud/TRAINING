package com.msedcl.main;

import java.util.Scanner;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeCRUDMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		int employeeId, choice;
		String name, continueChoice;
		double salary;

		do {
			System.out.println("Menu");
			System.out.println("1. Add New Employee");
			System.out.println("2. Search Employee by Employee Id");
			System.out.println("3. Remove Employee by Employee Id");
			System.out.println("4. Update Employee by Employee Id");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Name");
				name = scanner.next();
				System.out.println("Enter Salary");
				salary = scanner.nextDouble();
				Employee employee = new Employee(0, name, salary);
				addNewEmployee(employee);
				break;
			case 2:
				System.out.println("Enter Employee ID");
				employeeId = scanner.nextInt();
				getEmployeeByEmployeeId(employeeId);			
				break;
			case 3:
				System.out.println("Enter Employee ID");
				employeeId = scanner.nextInt();				
				removeEmployeeByEmployeeId(employeeId);			
				break;
			case 4:
				System.out.println("Enter Employee ID");
				employeeId = scanner.nextInt();
//				System.out.println("Enter Name");
//				name = scanner.next();
				System.out.println("Enter Salary");
				salary = scanner.nextDouble();
				Employee employee1 = new Employee(employeeId, null, salary);
				updateEmployee(employee1);
				break;	
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue?");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));


	}
	
	public static void removeEmployeeByEmployeeId(int employeeId) {
		//1. Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();
		
		//2.getEmployee by EmployeeId
		
		Employee existingEmployee = entityManager.find(Employee.class, employeeId);
		
		if(existingEmployee !=null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(existingEmployee);
			entityTransaction.commit();
			System.out.println("Employee deleted successfully.");
		}
		else {
			System.out.println("Invalid Employee.");
		}
		
		
		//3. Close EntityManager
		entityManager.close();
		
		
				
	}
	
	public static void getEmployeeByEmployeeId(int employeeId) {
		
		//1. Create EntityManager object		
		EntityManager entityManager = HibernateUtil.getEntityManager();
		
		//2. Get Employee from database
		Employee employee = entityManager.find(Employee.class, employeeId);
		if(employee != null)
			System.out.println(employee);
		else 
			System.out.println("Invalid EmployeeId");
		
		//3. Close EntityManager
		entityManager.close();
		
	}
	
	public static void updateEmployee(Employee employee) {
		//1. Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();//Transient
		Employee existingEmployee = entityManager.find(Employee.class, employee.getEmployeeId());
		
		if(existingEmployee != null) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
//		existingEmployee.setName(employee.getName());
	existingEmployee.setSalary(employee.getSalary());
		//entityManager.merge(employee);
		entityTransaction.commit();
		System.out.println("Employee Updated successfully");
		}
		else
			System.out.println("Invalid Employee");	
		
		entityManager.close();
	}
	

	public static void addNewEmployee(Employee employee) {
		//States :: 1. Transient 2. Persistent 3. Detached 4.Removed
		
		// Employee Transient
		//1. Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();//Transient
		
		//2. Create Transaction object
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		//3. Start Transaction
		entityTransaction.begin();
		
		//4. Save employee object into database
		
		entityManager.persist(employee);//Persistent
		
		//entityManager.remove(employee);//Removed
		
		//5. Commit Transaction
		entityTransaction.commit();//Detached
		
		//6. Close EntityManager
		entityManager.close();
		
		System.out.println("Employee Created, with employeeId = " + employee.getEmployeeId());
				
	}
}
