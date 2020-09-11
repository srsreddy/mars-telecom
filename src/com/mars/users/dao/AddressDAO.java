package com.mars.users.dao;

import java.util.List;

import com.mars.users.model.Address;
import com.mars.users.model.Employee;

public interface AddressDAO {
	public void saveAddress(Address address);
	public int deleteAddress(int id);
	public Address getAddressById(int id);
	public void updateAddress(Address address);
}
