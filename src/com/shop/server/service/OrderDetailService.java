package com.shop.server.service;

import com.shop.server.model.Order;
import com.shop.server.vo.OrderVo;

public interface OrderDetailService {
	
	public void insertOrder(OrderVo order);
	public Order getOrderDetailbyId(String trackingNumber);

}
