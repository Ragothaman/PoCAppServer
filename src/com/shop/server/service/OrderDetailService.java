package com.shop.server.service;

import com.shop.server.model.OrderDetails;
import com.shop.server.vo.OrderVo;

public interface OrderDetailService {
	
	public boolean insertOrder(OrderVo order);
	public OrderDetails getOrderDetailbyId(String trackingNumber);

}
