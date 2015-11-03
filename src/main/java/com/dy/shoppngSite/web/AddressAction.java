package com.dy.shoppngSite.web;

import java.util.List;

import com.dy.shoppingSite.entity.Address;
import com.dy.shoppingSite.entity.User;
import com.dy.shoppingSite.service.AddressService;
import com.opensymphony.xwork2.ActionContext;

public class AddressAction {
	private AddressService addressService;
	private Address address;
	String userid = ((User)ActionContext.getContext().getSession().get("user")).getId();
	//更改默认
	public String setDefault(){
		
		if(address.getIsDefault()=="1"){
			
			addressService.setDefualt(address.getId());
			//addressService.setNotDefault(userid);
			
		}else{
			//addressService.setDefualt(address.getId());
			addressService.setNotDefault(userid);
		}
		return "oprsuc";
	}
	
	//添加地址
	public String add(){
		addressService.addAddress(address);
		return "oprsuc";
	}
	
	//地址列表
	private List<Address> addresses;
	//获取地址列表
	public String list(){
		//String userid = ((User)ActionContext.getContext().getSession().get("user")).getId();
		addresses = addressService.getAddress(userid);
		return "list";
		
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

}
