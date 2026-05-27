package com.msedcl.main.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.msedcl.main.configuaration.SpringConfiguration;
import com.msedcl.main.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final SpringConfiguration springConfiguration;

	private JdbcTemplate jdbcTemplate;
	
	private static final String ADD_NEW_EMPLOYEE = "INSERT INTO employee_details(name,salary) VALUES(?,?)";
	
	private static final String UPDATE_EMPLOYEE = "UPDATE employee_details set name = ?, salary = ? WHERE employee_id = ? ";
	
	private static final String DELETE_EMPLOYEE = "DELETE FROM employee_details WHERE employee_id = ? ";
	
	private static final String SELECT_EMPLOYEE_BY_EMPLOYEE_ID = "SELECT * FROM employee_details WHERE employee_id = ? ";
	
	private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee_details ";
	
	public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate, SpringConfiguration springConfiguration) {
		super();
		System.out.println("Overloaded Constructor called - EmployeeRepositoryImpl.");
		this.jdbcTemplate = jdbcTemplate;
		this.springConfiguration = springConfiguration;
	}

	@Override
	@Transactional
	public Employee addNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		int rowInserted = jdbcTemplate.update(ADD_NEW_EMPLOYEE, employee.getName(),employee.getSalary());
		if(rowInserted > 0)
			return employee;
		else
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		int rowUpdated = jdbcTemplate.update(UPDATE_EMPLOYEE, employee.getName(), employee.getSalary(), employee.getEmployeeId());
		if(rowUpdated > 0)
			return employee;
		else
		return null;
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		
		return jdbcTemplate.queryForObject(SELECT_EMPLOYEE_BY_EMPLOYEE_ID, 
				(rs,row) -> new Employee(rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3)),
				employeeId);
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		int rowDeleted = jdbcTemplate.update(DELETE_EMPLOYEE, employeeId);
		if(rowDeleted > 0) {
			System.out.println("Employee Deleted.");
			return true;
		}
		else
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
//		RowMapper<Employee> employeeRowMapper = (rs, row) -> 
//		new Employee(
//				rs.getInt(1), 
//				rs.getString(2), 
//				rs.getDouble(3));
//		
//		
//		return jdbcTemplate.query(SELECT_ALL_EMPLOYEE, employeeRowMapper);

		return jdbcTemplate.query(SELECT_ALL_EMPLOYEES,
				(rs, rowCount) -> new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
	}

	@Override
	public List<Employee> getAllEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getCountOfEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getMaxSalaryOfEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
