package com.msedcl.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.repository.EmployeeRepository;
import com.msedcl.main.repository.EmployeeRepositoryImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
private  EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
	super();
	this.employeeRepository = employeeRepository;
}

	@Override
	public Employee addNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.addNewEmployee(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.updateEmployee(employee);
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return employeeRepository.deleteEmployeeByEmployeeId(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.getAllEmployees();
	}

	@Override
	public List<Employee> getAllEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return employeeRepository.getAllEmployeeByName(name);
	}

	@Override
	public Long getCountOfEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.getCountOfEmployees();
	}

	@Override
	public Employee getMaxSalaryOfEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.getMaxSalaryOfEmployee();
	}

}
