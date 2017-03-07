package com.shop.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.server.model.OrderDetails;
import com.shop.server.model.UserDetails;
import com.shop.server.persistence.OrderDetailDao;
import com.shop.server.service.ContactDetailService;
import com.shop.server.service.OrderDetailService;
import com.shop.server.vo.OrderVo;

@Service(value = "OrderDetailService")
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailDao orderDetailDao;
	@Override
	public boolean insertOrder(OrderVo order) {
		int productid=order.getProductid();
		int contactid=order.getContactid();
		int price=order.getPrice();
		int qty=order.getQty();
		String trackingNumber=order.getTrackingno();
		OrderDetails orderdetail=new OrderDetails();
		orderdetail.setContactid(contactid);
		orderdetail.setProductid(productid);
		orderdetail.setPrice(price);
		orderdetail.setQty(qty);
		orderdetail.setTrackingno(trackingNumber);
		System.out.println("insertContact call started");
		boolean result=orderDetailDao.insertOrder(orderdetail);
		return result;
		
	}

	@Override
	public OrderDetails getOrderDetailbyId(String trackingNumber) {
		System.out.println("getOrderDetailbyId in OrderDetailServiceImpl starts");
		OrderDetails orderDetails = orderDetailDao.getOrderDetailbyId(trackingNumber);
		System.out.println("getOrderDetailbyId in OrderDetailServiceImpl ends");
		return orderDetails;
	}

}
