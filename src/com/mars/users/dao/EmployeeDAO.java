package com.mars.users.dao;

import java.util.List;

import com.mars.users.model.Employee;

public interface EmployeeDAO {
	
	public void save(Employee e);
	public List<Employee> getEmployees();
	public long getEmployeesCount();
	public Employee getEmployeeById(int id);
	public void updateEmployee(Employee emp);
	public int removeEmployee(int id);
}
