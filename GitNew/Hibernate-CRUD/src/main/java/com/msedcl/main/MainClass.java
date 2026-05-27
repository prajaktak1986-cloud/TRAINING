package com.msedcl.main;

import com.msedcl.main.util.CreateEmployee;

public class MainClass {
public static void main(String[] args) {
	System.out.println("new project begins here for employee - CRUD operations");
	CreateEmployee createEmployee = new CreateEmployee();
	createEmployee.createNewEmployee();
	System.out.println("Prajakta Main function.");
}
}
