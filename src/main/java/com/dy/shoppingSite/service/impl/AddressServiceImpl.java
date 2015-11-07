package com.dy.shoppingSite.service.impl;

import java.util.List;

import com.dy.shoppingSite.dao.AddressDao;
import com.dy.shoppingSite.entity.Address;
import com.dy.shoppingSite.entity.User;
import com.dy.shoppingSite.service.AddressService;
import com.dy.shoppingSite.util.MyUntil;
import com.opensymphony.xwork2.ActionContext;

public class AddressServiceImpl implements AddressService{
	
	private AddressDao addressDao;
	
	public AddressDao getAddressDao() {
		return addressDao;
	}
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}
	@Override
	public void addAddress(Address address) {
		String userid = ((User)ActionContext.getContext().getSession().get("user")).getId();
		//如果原来没有设置默认地址，就设置为默认
		if(address.getIsDefault() == null){
			//选框为空
			address.setIsDefault("2");
		}else{
			address.setIsDefault("1");
			addressDao.setNotDefault(userid);
		}
		address.setId(MyUntil.getID());
		
		address.setUserid(userid);
		addressDao.addAddress(address);
		
		
	}
	@Override
	public List<Address> getAddress(String userid) {
		// TODO Auto-generated method stub
		return addressDao.getAddress(userid);
	}
	
	@Override
	public void setDefualt(Address address) {
		// TODO Auto-generated method stub
		//不管是设置默认收货地址还是取消收货地址，都需要将所有地址设置为非默认
		//再根据para传来的isDefault来选择
		addressDao.setNotDefault(address.getUserid());
		if(address.getIsDefault().equals("2")){
			addressDao.setDefualt(address.getId());
		}
		
	}
	

}
