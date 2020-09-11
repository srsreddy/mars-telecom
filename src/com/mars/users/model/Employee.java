package com.mars.users.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	public Employee() {
		
	}
	
	public Employee(String lastName, String firstName, String job) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.job = job;
	}
	
	private Set address;
	
	public Set getAddress() {
		return address;
	}

	public void setAddress(Set address) {
		this.address = address;
	}

	@Id
	@Column(name = "empid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name = "job")
	private String job;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

}
