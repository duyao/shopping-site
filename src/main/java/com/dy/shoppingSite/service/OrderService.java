package com.dy.shoppingSite.service;

import java.util.List;

import com.dy.shoppingSite.entity.Order;
import com.dy.shoppingSite.entity.OrderDetail;

public interface OrderService {
	public void addOrder(Order order, List<OrderDetail> details);

}
