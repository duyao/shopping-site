package com.dy.shoppngSite.web;

import java.util.List;

import com.dy.shoppingSite.entity.Address;
import com.dy.shoppingSite.entity.Order;
import com.dy.shoppingSite.entity.OrderDetail;
import com.dy.shoppingSite.entity.User;
import com.dy.shoppingSite.service.AddressService;
import com.dy.shoppingSite.service.GoodsService;
import com.dy.shoppingSite.service.OrderService;
import com.opensymphony.xwork2.ActionContext;

public class OrderAction {
	private OrderService orderService;
	private List<OrderDetail> orderDetails;
	
	private GoodsService goodsService;
	//结算页面得到收货地址
	private AddressService addressService;
	private List<Address> addresses;
	public String add(){
		//通过session中的用户id得到地址
		User user = ((User) ActionContext.getContext().getSession().get("user"));
		if(user == null){
			return "login";
		}
		String userid = user.getId();
		addresses = addressService.getAddress(userid);
		
		//为orderDetails中的每个物品详细物品信息
		for (OrderDetail orderDetail : orderDetails) {
			//System.out.println(orderDetail.toString());
			//System.out.println(goodsService.getGoodsById(orderDetail.getGoodsId()));
			orderDetail.setGoods(goodsService.getGoodsById(orderDetail.getGoodsId()));
			
		}
		
		return "add";
	}
	
	private Order order;
	public String submit(){
		User user = ((User) ActionContext.getContext().getSession().get("user"));
		if(user == null){
			return "login";
		}
		String userid = user.getId();
		order.setUserId(userid);
		orderService.addOrder(order, orderDetails);
		return "submit";
		
	}
	
	
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public GoodsService getGoodsService() {
		return goodsService;
	}
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
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


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}

}
