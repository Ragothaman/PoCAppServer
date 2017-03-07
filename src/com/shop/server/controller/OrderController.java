package com.shop.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.server.model.Order;
import com.shop.server.service.OrderDetailService;
import com.shop.server.vo.OrderVo;

@RestController
public class OrderController {
	@Autowired
	private OrderDetailService orderDetailService;
	
	@RequestMapping(value = "/order/insertOrder", method = RequestMethod.POST)
	public ResponseEntity<String> insertOrder(@RequestBody OrderVo orderVo) {
		System.out.println("insertOrder ");
		//generate unique number
		String uniqueNumber=java.util.UUID.randomUUID().toString();
		orderVo.setTrackingno(uniqueNumber);
		orderDetailService.insertOrder(orderVo);
		return new ResponseEntity<String>(uniqueNumber, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/order/getOrderDetail", method = RequestMethod.POST)
	public ResponseEntity<Order> getOrderDetails(@RequestBody String trackingNumber) {
		System.out.println("getOrderDetail ");
		Order result = orderDetailService.getOrderDetailbyId(trackingNumber);
		return new ResponseEntity<Order>(result, HttpStatus.OK);
	}
}
