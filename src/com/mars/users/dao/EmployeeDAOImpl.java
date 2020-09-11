package com.mars.users.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mars.users.model.Employee;


public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Override
	public void save(Employee emp) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		
		Query q=session.createQuery("select max(empId) from Employee");  
		List<Integer> list=q.list();  
		System.out.println(list.get(0));  
		emp.setEmpId(list.get(0)+1);
		session.save(emp);
		txn.commit();
		session.close();
	}

	@Override
	public List<Employee> getEmployees() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		List<Employee> employees = session.createQuery("FROM Employee").list();
		session.close();
		return employees;
	}

	@Override
	public long getEmployeesCount() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		long empCount = (Long)session.createQuery("select count(*) from Employee").uniqueResult();
		return empCount;
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Employee emp = (Employee) session.get(Employee.class, new Integer(id));
		session.close();
		return emp;
	}
	
	@Override
	public void updateEmployee(Employee emp) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		session.update(emp);
		txn.commit();
		session.close();
	}
	
	@Override
	public int removeEmployee(int id) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		Employee emp = (Employee) session.load(Employee.class, new Integer(id));
		if(null != emp){
			session.delete(emp);
		}
		txn.commit();
		session.close();
		return emp.getEmpId();
	}
}
