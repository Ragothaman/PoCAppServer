package com.shop.server.persistence.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.server.model.Contacts;
import com.shop.server.persistence.AbstractDao;
import com.shop.server.persistence.ContactDetailDao;

@Repository(value = "ContactDetailDao")
@Transactional
public class ContactDetailDaoImpl extends AbstractDao implements ContactDetailDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Contacts> getAllContacts() {
		System.out.println("getAllContacts in ContactDetailDaoImpl starts");
		Criteria c = getSession().createCriteria(Contacts.class);
		System.out.println((List<Contacts>) c.list());
		System.out.println("getAllContacts in ContactDetailDaoImpl ends");
		return (List<Contacts>) c.list();
	}

	@Override
	public Contacts getContactById(int contactId) {
		System.out.println("getContactById in ContactDetailDaoImpl starts");
		Criteria c = getSession().createCriteria(Contacts.class);
		c.add(Restrictions.eq("id",contactId));
		System.out.println((Contacts) c.list().get(0));
		System.out.println("getContactById in ContactDetailDaoImpl ends");
		return (Contacts) c.list().get(0);
	}

	@Override
	public Contacts getContactByName(String contactName) {
		System.out.println("getContactByname in ContactDetailDaoImpl starts");
		Criteria c = getSession().createCriteria(Contacts.class);
		c.add(Restrictions.eq("name",contactName));
		System.out.println((Contacts) c.list().get(0));
		System.out.println("getContactByname in ContactDetailDaoImpl ends");
		return (Contacts) c.list().get(0);
	}

	@Override
	public int insertContact(Contacts contacts) {
		int id=0;
		System.out.println("InsertContact in ContactDetailDaoImpl");
		try{
		getSession().persist(contacts);
		String contactno=contacts.getContactno();
		
		Criteria c = getSession().createCriteria(Contacts.class);
		c.add(Restrictions.eq("contactno",contactno));
		Contacts contactreturned=(Contacts) c.list().get(0);
		id=contactreturned.getId();
		System.out.println("InsertContact in ContactDetailDaoImpl ends"+id);
		return id;
		}
		catch(Exception e)
		{
		return 0;
		}
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
