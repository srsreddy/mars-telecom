package com.mars.users.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mars.users.model.Address;

public class AddressDAOImpl implements AddressDAO{

	@Override
	public void saveAddress(Address address) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		session.save(address);
		txn.commit();
		session.close();
	}

	@Override
	public Address getAddressById(int id) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Address addr = (Address) session.get(Address.class, new Integer(id));
		session.close();
		return addr;
	}
	
	@Override
	public void updateAddress(Address address) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		session.update(address);
		txn.commit();
		session.close();
		
	}
	
	@Override
	public int deleteAddress(int id) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		Address addr = (Address) session.load(Address.class, new Integer(id));
		if(addr != null){
			session.delete(addr);
		}
		txn.commit();
		session.close();
		return addr.getAddrId();
	}
	
}
