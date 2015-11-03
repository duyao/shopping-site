package com.dy.shoppingSite.service;

import java.util.List;

import com.dy.shoppingSite.entity.Address;


public interface AddressService {
	
	public void addAddress(Address address);
	public List<Address> getAddress(String userid);
	public void setDefualt(Address address);
}
