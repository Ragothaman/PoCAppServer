package com.shop.server.service;

import java.util.List;

import com.shop.server.model.Contacts;
import com.shop.server.vo.ContactVo;


public interface ContactDetailService {

	public List<Contacts> getAllContacts();
	public Contacts getContactById(int productid);
	public Contacts getContactByName(String contactName);
	public int insertContact(ContactVo contacts);
	public boolean deleteContactByContactId(int contactid);
	public boolean deleteContactByContactName(int contactName);
	
}
