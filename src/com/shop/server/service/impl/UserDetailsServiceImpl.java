package com.shop.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.server.model.UserDetails;
import com.shop.server.persistence.UserDetailsDao;
import com.shop.server.service.UserDetailsService;
import com.shop.server.vo.SignInVO;

@Service(value = "userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsDao userDetailsDao;
	
	@Override
	public List<UserDetails> getAllUsers() {
		System.out.println("getAllUsers in UserDetailsServiceImpl starts");
		List<UserDetails> allUsers = userDetailsDao.getAllUsers();
		System.out.println("getAllUsers in UserDetailsServiceImpl ends");
		return allUsers;
	}

	@Override
	public UserDetails getUser(String emailId) {
		System.out.println("getUser in UserDetailsServiceImpl starts");
		UserDetails user = userDetailsDao.getUserWithEmail(emailId);
		System.out.println("getUser in UserDetailsServiceImpl ends");
		return user;
	}

	@Override
	public String addUser(SignInVO userVO) {
		System.out.println("addUser in UserDetailsServiceImpl starts");
		
		System.out.println("addUser in UserDetailsServiceImpl ends");
		return null;
	}

	@Override
	public String deleteUser(String emailId) {
		System.out.println("deleteUser in UserDetailsServiceImpl starts");
		userDetailsDao.deleteUser(emailId);	
		
		System.out.println("deleteUser in UserDetailsServiceImpl ends");
		return null;
	}

	@Override
	public String updateUser(UserDetails user) {
		System.out.println("updateUser in UserDetailsServiceImpl starts");
		if (user != null) {
			userDetailsDao.updateUser(user);	
		}
		System.out.println("updateUser in UserDetailsServiceImpl ends");
		return null;
	}
	
	@Override
	public boolean signInUser(String userId, String password) {
		System.out.println("signInUser in UserDetailsServiceImpl starts");
		UserDetails userFromDB = null;
		boolean authenticated = false;
		if(!userId.equals("") && userId != null) {
			userFromDB = userDetailsDao.getUserWithEmail(userId);
		}
			
		if(userFromDB != null) {
			if(userId.equals(userFromDB.getEmailId())) {
				if(password.equals(userFromDB.getPassword())) {
					authenticated = true;
				}
			}
		}
		System.out.println("signInUser in UserDetailsServiceImpl ends");
		return authenticated;
	}
	
}
