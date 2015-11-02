package com.dy.shoppngSite.web;

import com.dy.shoppingSite.entity.Address;
import com.dy.shoppingSite.service.AddressService;

public class AddressAction {
	private AddressService addressService;
	private Address address;
	public String add(){
		addressService.addAddress(address);
		return "addAddress";
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

}
