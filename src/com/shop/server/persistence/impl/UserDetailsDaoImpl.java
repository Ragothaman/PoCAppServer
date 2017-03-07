package com.shop.server.persistence.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.server.model.UserDetails;
import com.shop.server.persistence.AbstractDao;
import com.shop.server.persistence.UserDetailsDao;

@Repository(value = "userDetailsDao")
@Transactional
public class UserDetailsDaoImpl extends AbstractDao implements UserDetailsDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetails> getAllUsers() {
		System.out.println("getAllUsers in UserDetailsDaoImpl starts");
		Criteria c = getSession().createCriteria(UserDetails.class);
		System.out.println((List<UserDetails>) c.list());
		System.out.println("getAllUsers in UserDetailsDaoImpl ends");
		return (List<UserDetails>) c.list();
	}

	@Override
	public void addUser(UserDetails user) {
		System.out.println("addUser in UserDetailsDaoImpl starts");
		try {
			getSession().persist(user);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("addUser in UserDetailsDaoImpl ends");
	}

	@Override
	public void deleteUser(String userId) {
		System.out.println("deleteUser in UserDetailsDaoImpl starts");
		Query query = getSession().createQuery("DELETE FROM UserDetails WHERE userId = :userId");
		query.setString("userId", userId);
		query.executeUpdate();
		System.out.println("deleteUser in UserDetailsDaoImpl ends");
	}
	
	@Override
	public UserDetails getUserWithEmail(String userId) {
		System.out.println("getUserWithEmail in UserDetailsDaoImpl starts");
		Query query = getSession().createQuery("FROM UserDetails WHERE userId = :userId");
		query.setString("userId", userId);
		UserDetails user = (UserDetails) query.uniqueResult();
		//System.out.println("User -> " + user.getMobileNumber());
		System.out.println("getUserWithEmail in UserDetailsDaoImpl ends");
		return user;
	}
	
	@Override
	public void updateUser(UserDetails user) {
		System.out.println("updateUser in UserDetailsDaoImpl starts");
		getSession().update(user);
		System.out.println("updateUser in UserDetailsDaoImpl ends");
	}

}
