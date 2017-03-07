package com.shop.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.server.model.Order;
import com.shop.server.persistence.OrderDetailDao;
import com.shop.server.service.OrderDetailService;
import com.shop.server.vo.OrderVo;

@Service(value = "OrderDetailService")
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailDao orderDetailDao;
	@Override
	public void insertOrder(OrderVo order) {
		int productid=order.getProductid();
		int contactid=order.getContactid();
		int price=order.getPrice();
		int qty=order.getQty();
		String trackingNumber=order.getTrackingno();
		Order orderdetail=new Order();
		orderdetail.setContId(contactid);
		orderdetail.setProdId(productid);
		orderdetail.setPrice(price);
		orderdetail.setQty(qty);
		orderdetail.setTrackNo(trackingNumber);
		System.out.println("insertContact call started"+orderdetail.getId()+orderdetail.getTrackNo());
		orderDetailDao.insertOrder(orderdetail);
		//return result;
		
	}

	@Override
	public Order getOrderDetailbyId(String trackingNumber) {
		System.out.println("getOrderDetailbyId in OrderDetailServiceImpl starts");
		Order orderDetails = orderDetailDao.getOrderDetailbyId(trackingNumber);
		System.out.println("getOrderDetailbyId in OrderDetailServiceImpl ends"+orderDetails.getProdId());
		return orderDetails;
	}

}
