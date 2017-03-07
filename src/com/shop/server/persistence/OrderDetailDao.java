package com.shop.server.persistence;

import com.shop.server.model.Order;


public interface OrderDetailDao {
	
	public void insertOrder(Order order);
	public Order getOrderDetailbyId(String trackingNumber);


}
