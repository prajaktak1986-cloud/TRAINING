package com.msedcl.main;

import java.util.Arrays;
import java.util.List;

import com.msedcl.main.entity.Department;
import com.msedcl.main.entity.Employee;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OneToManyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      // select ();
		insert();
	}
	
	public static void select() {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		Employee existingEmployee = entityManager.find(Employee.class, 1);
		entityManager.close();
		System.out.println(existingEmployee);
		
	}
	
public static void insert() {
	EntityManager entityManager = HibernateUtil.getEntityManager();
	EntityTransaction entityTransaction =  entityManager.getTransaction();
	entityTransaction.begin();
//	Employee employee1 = new Employee(0, "Mita", 160000,
//			new Department(0,"IT")
//			);
	Employee employee1 = new Employee(0, "naresh", 170000,
	new Department(0,"HR")
	);
	
	//Employee employee1 = new Employee(0, "Mita", 160000, 1);
	entityManager.persist(employee1);
	entityTransaction.commit();
	entityManager.close();
	
	}

//	public static void select() {
//		
//		EntityManager entityManager = HibernateUtil.getEntityManager();
//		Department existingDepartment = entityManager.find(Department.class, 1);
//		entityManager.close();
//		System.out.println(existingDepartment.getDepartmentName());
//		List<Employee> employees = existingDepartment.getEmployees();
//		employees.forEach(e -> System.out.println(e));
//		
//	}
//	
//	private static void insert() {
//		EntityManager entityManager = HibernateUtil.getEntityManager();
//		EntityTransaction entityTransaction =  entityManager.getTransaction();
//		entityTransaction.begin();
//		Employee employee1 = new Employee(0, "Abhay", 160000);
//		Employee employee2 = new Employee(0, "Prasad", 180000);
//		Employee employee3 = new Employee(0, "Shailesh", 190000);
//		
//		List<Employee> employees = Arrays.asList(employee1,employee2,employee3);
//		
//		Department department = new Department(0,"Sales",employees);
//		
//		entityManager.persist(department);
//		
//		entityTransaction.commit();
//		entityManager.close();
//		
//		
//	}
		

}
