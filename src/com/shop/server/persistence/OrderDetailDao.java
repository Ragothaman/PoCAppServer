package com.shop.server.persistence;

import com.shop.server.model.OrderDetails;


public interface OrderDetailDao {
	
	public boolean insertOrder(OrderDetails order);
	public OrderDetails getOrderDetailbyId(String trackingNumber);


}
