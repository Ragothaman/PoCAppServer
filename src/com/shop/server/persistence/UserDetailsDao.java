package com.shop.server.persistence;

import java.util.List;

import com.shop.server.model.UserDetails;

public interface UserDetailsDao {

	public List<UserDetails> getAllUsers();
	public void addUser(UserDetails user);
	public void deleteUser(String emailId);
	public void updateUser(UserDetails user);
	public UserDetails getUserWithEmail(String emailId);
}
