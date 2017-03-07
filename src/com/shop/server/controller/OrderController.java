package com.shop.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.server.model.Contacts;
import com.shop.server.model.OrderDetails;
import com.shop.server.service.ContactDetailService;
import com.shop.server.service.OrderDetailService;
import com.shop.server.vo.ContactVo;
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
		boolean result = orderDetailService.insertOrder(orderVo);
		HttpStatus status=HttpStatus.OK;
		if(result)
		{
			status=HttpStatus.OK;
		}
		else
		{
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(uniqueNumber, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/order/getOrderDetail", method = RequestMethod.POST)
	public ResponseEntity<OrderDetails> getOrderDetails(@RequestBody String trackingNumber) {
		System.out.println("getOrderDetail ");
		OrderDetails result = orderDetailService.getOrderDetailbyId(trackingNumber);
		return new ResponseEntity<OrderDetails>(result, HttpStatus.OK);
	}
}
