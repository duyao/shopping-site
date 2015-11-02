package com.dy.shoppingSite.dao;

import java.util.List;

import com.dy.shoppingSite.entity.Address;

public interface AddressDao {
	public void addAddress(Address address);
	public List<Address> getAddress(String userid);
}
