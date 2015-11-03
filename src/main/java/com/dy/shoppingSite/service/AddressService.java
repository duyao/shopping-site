package com.dy.shoppingSite.service;

import java.util.List;

import com.dy.shoppingSite.entity.Address;


public interface AddressService {
	
	public void addAddress(Address address);
	public List<Address> getAddress(String userid);
	public void setDefualt(String id);
	public void setNotDefault(String userid);
}
