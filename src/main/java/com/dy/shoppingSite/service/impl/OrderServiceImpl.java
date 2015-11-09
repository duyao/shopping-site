package com.dy.shoppingSite.service.impl;

import java.util.Date;
import java.util.List;

import com.dy.shoppingSite.dao.OrderDao;
import com.dy.shoppingSite.dao.OrderDetailDao;
import com.dy.shoppingSite.entity.Order;
import com.dy.shoppingSite.entity.OrderDetail;
import com.dy.shoppingSite.service.OrderService;
import com.dy.shoppingSite.util.MyUntil;

public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao;
	private OrderDetailDao orderDetailDao;

	@Override
	public void addOrder(Order order, List<OrderDetail> details) {
		//一个order中有多个orderDetails，因此在提交order都要提交
		order.setId(MyUntil.getID());
		order.setOrderTime(new Date());
		//状态信息：1代付款2已付款3未发货4已发货5已完成
		order.setStatus("1");
		orderDao.addOrder(order);
		
		for (OrderDetail orderDetail : details) {
			orderDetail.setId(MyUntil.getID());
			orderDetail.setOrderId(order.getId());
			orderDetailDao.addOrderDetail(orderDetail);
		}
		
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public OrderDetailDao getOrderDetailDao() {
		return orderDetailDao;
	}

	public void setOrderDetailDao(OrderDetailDao orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

}
