package com.shop.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.server.model.Contacts;
import com.shop.server.persistence.ContactDetailDao;
import com.shop.server.service.ContactDetailService;
import com.shop.server.vo.ContactVo;

@Service(value = "ContactDetailService")
@Transactional
public class ContactDetailServiceImpl implements ContactDetailService {

	@Autowired
	private ContactDetailDao contactDetailDao;
	@Override
	public List<Contacts> getAllContacts() {
		System.out.println("getAllContacts in ContactDetailServiceImpl starts");
		List<Contacts> contacts = contactDetailDao.getAllContacts();
		System.out.println("getOrderDetailbyId in OrderDetailServiceImpl ends");
		return contacts;
	}

	@Override
	public Contacts getContactById(int contactid) {
		System.out.println("getContactById in ContactDetailServiceImpl starts");
		Contacts contacts = contactDetailDao.getContactById(contactid);
		System.out.println("getContactById in OrderDetailServiceImpl ends");
		return contacts;
	}

	@Override
	public Contacts getContactByName(String contactName) {
		System.out.println("getContactByName in ContactDetailServiceImpl starts");
		Contacts contacts = contactDetailDao.getContactByName(contactName);
		System.out.println("getContactByName in OrderDetailServiceImpl ends");
		return contacts;
	}

	@Override
	public int insertContact(ContactVo contacts) {
		
		String name=contacts.getName();
		String contactNo=contacts.getContactno();
		String state=contacts.getState();
		String country=contacts.getCountry();
		String geoLoc=contacts.getGeoloc();
		String pincode=contacts.getPincode();
		String address=contacts.getAddress();
		Contacts contact=new Contacts();
		contact.setContactno(contactNo);
		contact.setName(name);
		contact.setCountry(country);
		contact.setState(state);
		contact.setGeoloc(geoLoc);
		contact.setPincode(pincode);
		contact.setAddress(address);
		System.out.println("insertContact call started");
		int result=contactDetailDao.insertContact(contact);
		return result;
	}

	@Override
	public boolean deleteContactByContactId(int contactid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContactByContactName(int contactName) {
		// TODO Auto-generated method stub
		return false;
	}

}
