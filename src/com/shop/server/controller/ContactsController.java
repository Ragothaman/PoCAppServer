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
import com.shop.server.service.ContactDetailService;
import com.shop.server.vo.ContactVo;



@RestController
public class ContactsController {
	@Autowired
	private ContactDetailService contactDetailService;
	
	@RequestMapping(value = "/contacts/getallcontacts", method = RequestMethod.POST)
	public ResponseEntity<List<Contacts>> getAllProducts() {
		System.out.println("GetAllProducts ");
		List<Contacts> contacts = contactDetailService.getAllContacts();
		return new ResponseEntity<List<Contacts>>(contacts, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/contacts/insertContacts", method = RequestMethod.POST)
	public ResponseEntity<Integer> insertContacts(@RequestBody ContactVo contactVo) {
		System.out.println("GetAllProducts ");
		
		int result = contactDetailService.insertContact(contactVo);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/contacts/getcontactbyid", method = RequestMethod.POST)
	public ResponseEntity<Contacts> getContactById(@RequestBody ContactVo contactVo) {
		System.out.println("GetAllProducts ");
		int contactId=contactVo.getId();
		Contacts result = contactDetailService.getContactById(contactId);
		return new ResponseEntity<Contacts>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/contacts/getcontactbyname", method = RequestMethod.POST)
	public ResponseEntity<Contacts> getContactByName(@RequestBody ContactVo contactVo) {
		System.out.println("GetAllProducts ");
		String contactName=contactVo.getName();
		Contacts result = contactDetailService.getContactByName(contactName);
		return new ResponseEntity<Contacts>(result, HttpStatus.OK);
	}
	
	
	
	
	
}
