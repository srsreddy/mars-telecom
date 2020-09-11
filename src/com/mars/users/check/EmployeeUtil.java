package com.mars.users.check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.mars.users.dao.EmployeeDAO;
import com.mars.users.dao.EmployeeDAOImpl;
import com.mars.users.model.Employee;

public class EmployeeUtil {

	public static void addEmployee() throws IOException {
		System.out.println("Adding an Employee");
		System.out.println("Please enter Employee Last Name");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String empLastName = reader.readLine();
		System.out.println("Please enter Employee First Name");
		String empFirstName = reader.readLine();
		System.out.println("Please enter Employee Job");
		String empJob = reader.readLine();
		Employee emp = new Employee(empLastName, empFirstName, empJob);
		EmployeeDAO edao = new EmployeeDAOImpl();
		edao.save(emp);
	}
	
	public static void editEmployee() throws IOException {
		System.out.println("Editing an Employee");
		System.out.println("Enter the Emp Id of the Employee");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int empId = Integer.parseInt(reader.readLine());
		EmployeeDAO edao = new EmployeeDAOImpl();
		Employee empl = edao.getEmployeeById(empId);
		if(empl!=null) {
			System.out.println("Please enter Employee Last Name");
			empl.setLastName(reader.readLine());
			System.out.println("Please enter Employee First Name");
			empl.setFirstName(reader.readLine());
			System.out.println("Please enter Employee Job");
			empl.setJob(reader.readLine());
			edao = new EmployeeDAOImpl();
			edao.updateEmployee(empl);
		}else {
			System.out.println("Employee with give Emp Id : "+empId+" doesnt exist.");
		}
		
	}
	
	public static void deleteEmployee() throws IOException {
		System.out.println("Delete an Employee");
		System.out.println("Enter the Emp Id of the Employee");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int empId = Integer.parseInt(reader.readLine());
		EmployeeDAO edao = new EmployeeDAOImpl();
		Employee empl = edao.getEmployeeById(empId);
		if(empl!=null) {
			edao = new EmployeeDAOImpl();
			int empRemoved = edao.removeEmployee(empl.getEmpId());
			System.out.println("Employee with Id : "+empRemoved  +" is removed");
		}else {
			System.out.println("Employee with give Emp Id : "+empId+" doesnt exist.");
		}
		
	}
	
	public static void countEmployees() throws IOException {
		EmployeeDAO edao = new EmployeeDAOImpl();
		long noOfEmps = edao.getEmployeesCount();
		System.out.println("The no of Employees are :"+noOfEmps);
	}
	
	public static void listEmployees() throws IOException {
		EmployeeDAO edao = new EmployeeDAOImpl();
		List<Employee> emps = edao.getEmployees();
        for (Iterator iterator = emps.iterator(); iterator.hasNext();){
            Employee employee = (Employee) iterator.next();
            System.out.print("Emp Id : " + employee.getEmpId());
            System.out.print("Last Name: " + employee.getLastName());
            System.out.print("First Name: " + employee.getFirstName()); 
            System.out.println("  Salary: " + employee.getJob()); 
         }
	}

}
