package com.msedcl.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.entity.Product;
import com.msedcl.main.service.ProductService;

public class ProductMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext("com.msedcl.main");
		
		ProductService productService = annotationConfigApplicationContext.getBean(ProductService.class);
		
		Scanner scanner = new Scanner(System.in);
		int employeeId, choice;
		String name, continueChoice;
		double salary;

		do {
			System.out.println("Menu");
			System.out.println("1. Add New Product");
			System.out.println("2. Search Product by Name");
//			System.out.println("3. Remove Employee by Employee Id");
//			System.out.println("4. Update Employee by Employee Id");
//			System.out.println("5. Select All Employees");
//			System.out.println("6. Select Employee By Name.");
//			System.out.println("7. Total Employees.");
//			System.out.println("8. Max Salary Employee.");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
//			case 8:
//				Employee employee1 = employeeService.getMaxSalaryOfEmployee();
//			System.out.println("Max Salried Employees :: " + employee1);
//			      break;
//			case 7:
//			      Long count = employeeService.getCountOfEmployees();
//			System.out.println("Total Employees :: " + count);
//			      break;
			case 1:
				System.out.println("Enter Name");
				name = scanner.next();
				System.out.println("Enter Price");
				salary = scanner.nextDouble();
				Product product1 = new Product(0, name, salary);
				//addNewEmployee(employee);
				if(productService.addNewProduct(product1) != null) {
					System.out.println("New Product added successfully.");
					System.out.println("ProductID ::" + product1.getProductId());
				}
				break;
				
//			case 6: 
//				System.out.println("Enter Name");
//				name = scanner.next();
//				productService = productService.getAllEmployeeByName(name);
//				employeeListByName.forEach(e -> System.out.println(e));
//				break;
			
			case 2:
				System.out.println("Enter Product Name");
				String productName = scanner.next();
				//getEmployeeByEmployeeId(employeeId);	
				Product product = new Product();
				product = productService.getProductByName(productName);
				//System.out.println(product);
				if(product != null) {
					System.out.println(product);
				}else {
					System.out.println("Invalid product name");
				}
				break;
//			case 3:
//				System.out.println("Enter Employee ID");
//				employeeId = scanner.nextInt();				
//				//removeEmployeeByEmployeeId(employeeId);	
//				employeeService.deleteEmployeeByEmployeeId(employeeId);
//				break;
//			case 4:
//				System.out.println("Enter Employee ID");
//				employeeId = scanner.nextInt();
//				System.out.println("Enter Name");
//				name = scanner.next();
//				System.out.println("Enter Salary");
//				salary = scanner.nextDouble();
//				//Employee employee1 = new Employee(employeeId, null, salary);
//				 employee = new Employee(employeeId, name, salary);
//				//addNewEmployee(employee);
//				if(employeeService.updateEmployee(employee) != null) {
//					System.out.println("Employee updated successfully.");
//					System.out.println("Employee's New  Details ::" + employee);
//				}
//				//updateEmployee(employee1);
//				break;	
//			case 5:
//				List<Employee> employeeList = employeeService.getAllEmployees();
//				employeeList.forEach(e -> System.out.println(e));
//				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue?");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));

		annotationConfigApplicationContext.close();
		scanner.close();
	}

}
