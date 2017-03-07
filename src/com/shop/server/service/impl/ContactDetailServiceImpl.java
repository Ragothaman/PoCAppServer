package com.shop.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.server.model.Contacts;
import com.shop.server.model.Products;
import com.shop.server.persistence.ContactDetailDao;
import com.shop.server.persistence.UserDetailsDao;
import com.shop.server.service.ContactDetailService;
import com.shop.server.vo.ContactVo;

@Service(value = "ContactDetailService")
@Transactional
public class ContactDetailServiceImpl implements ContactDetailService {

	@Autowired
	private ContactDetailDao contactDetailDao;
	@Override
	public List<Contacts> getAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contacts getContactById(int productid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contacts getContactByName(String contactName) {
		// TODO Auto-generated method stub
		return null;
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
