package com.mars.users.check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mars.users.dao.AddressDAO;
import com.mars.users.dao.AddressDAOImpl;
import com.mars.users.dao.EmployeeDAO;
import com.mars.users.dao.EmployeeDAOImpl;
import com.mars.users.model.Address;
import com.mars.users.model.Employee;

public class AddressUtil {
	
	public static void addAddress() throws IOException {
		BufferedReader reader = null;
		String userPreference = null;
		System.out.println("Adding Address of an Employee");
		do {
			System.out.println("Enter the Emp Id of the Employee");
			reader = new BufferedReader(new InputStreamReader(System.in));
			int empId = Integer.parseInt(reader.readLine());
			EmployeeDAO edao = new EmployeeDAOImpl();
			Employee empl = edao.getEmployeeById(empId);
			System.out.println("out put coming till this point "+empl);
			if(empl!=null) {
				System.out.println("Please enter Employee Address Street Name");
				String empStreetName = reader.readLine();
				
				System.out.println("Please enter Employee Address City Name");
				String empCityName = reader.readLine();
				
				System.out.println("Please enter Employee Address State Name");
				String empStateName = reader.readLine();
				
				System.out.println("Please enter Employee Address Pincode");
				String empAddrPincode = reader.readLine();
				
				Address addr = new Address(empl.getEmpId(), empStreetName, empCityName, empStateName, empAddrPincode);
				Set set = new HashSet();
				set.add(addr);
				Employee emp = new Employee();
				emp.setEmpId(empl.getEmpId());
				emp.setLastName(empl.getLastName());
				emp.setAddress(set);
				edao.save(emp);
		
			}else {
				System.out.println("Employee with give Emp Id : "+empId+" doesnt exist.");
			}
			boolean flag = false;
			System.out.println("Do you want to edit Address of Employee : Y/N ");
			userPreference = reader.readLine();
			
		} while (userPreference!= null && userPreference.equalsIgnoreCase("Y"));
		
	}
	
	public static void editAddress() throws IOException {
		
		System.out.println("Editing Address of an Employee");
		System.out.println("Enter the Emp Id of the Employee");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int empId = Integer.parseInt(reader.readLine());
		EmployeeDAO edao = new EmployeeDAOImpl();
		Employee empl = edao.getEmployeeById(empId);
		Address addr = new Address();
		AddressDAO addrDao = new AddressDAOImpl();
		if(empl!=null) {
			addr.setAddrId(empl.getEmpId());
			System.out.println("Please enter Employee Street Name");
			addr.setStreet(reader.readLine());
			System.out.println("Please enter Employee City Name");
			addr.setCity(reader.readLine());
			System.out.println("Please enter Employee State Name");
			addr.setState(reader.readLine());
			System.out.println("Please enter Employee Pincode");
			addr.setPincode(reader.readLine());
			addrDao.updateAddress(addr);
		}else {
			System.out.println("Address with give Id : "+empId+" doesnt exist.");
		}		
	}
	

	public static void deleteAddress() throws IOException {
		System.out.println("Delete Address of an Employee");
		System.out.println("Enter the Address Id of an Employee");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int addrId = Integer.parseInt(reader.readLine());
		AddressDAO addrDao = new AddressDAOImpl();
		Address addr = addrDao.getAddressById(addrId);
		int addressRemoved = 0;
		if(addr!=null) {
			
			addressRemoved = addrDao.deleteAddress(addr.getAddrId());
			System.out.println("Address with Id : "+addressRemoved  +" is removed");
		}else {
			System.out.println("Address with given Id : "+addressRemoved+" doesnt exist.");
		}
	}

}
