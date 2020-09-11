package com.mars.users.check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import com.mars.users.dao.EmployeeDAO;
import com.mars.users.dao.EmployeeDAOImpl;
import com.mars.users.model.Address;
import com.mars.users.model.Employee;

public class EmployeeDetailsValidator {
	
	
	public static void main(String[] args) throws IOException {
		EmployeeDetailsValidator edv = new EmployeeDetailsValidator();
		BufferedReader reader = null;
		int userInput = 0;
		
		do {
			edv.populateOptions();
			System.out.println("Please Enter your Option");
			reader = new BufferedReader(new InputStreamReader(System.in));
			
			try {
				userInput = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			edv.performOperations(userInput);
		} while (userInput>0 && userInput<10);
		
	}
	
	public void populateOptions() {
		System.out.println("1 : Add Employee");
		System.out.println("2 : Edit Employee");
		System.out.println("3 : Delete Employee");
		System.out.println("4 : Add Address");
		System.out.println("5 : Edit Address");
		System.out.println("6 : Delete Address");
		System.out.println("7 : Count Employees");
		System.out.println("8 : List Employees");
	}
	
	public void performOperations(int value) throws IOException {
		switch (value) {
	        case 1:	EmployeeUtil.addEmployee();break;
	        case 2: EmployeeUtil.editEmployee();break;
	        case 3: EmployeeUtil.deleteEmployee();break;
	        case 4: AddressUtil.addAddress();break;
	        case 5: AddressUtil.editAddress();break;
	        case 6: AddressUtil.deleteAddress();break;
	        case 7: EmployeeUtil.countEmployees();break;
	        case 8: EmployeeUtil.listEmployees();break;
	        default: System.out.print("Invalid Option : "+value);break;
		}
	}
	


}
