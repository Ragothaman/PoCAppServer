package com.shop.server.persistence;

import java.util.List;

import com.shop.server.model.Contacts;

public interface ContactDetailDao {


	public List<Contacts> getAllContacts();
	public Contacts getContactById(int productid);
	public Contacts getContactByName(String contactName);
	public int insertContact(Contacts contacts);
	public boolean deleteContactByContactId(int contactid);
	public boolean deleteContactByContactName(int contactName);
	
}
