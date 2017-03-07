package com.shop.server.service;

import java.util.List;

import com.shop.server.model.UserDetails;
import com.shop.server.vo.SignInVO;

public interface UserDetailsService {

	public List<UserDetails> getAllUsers();
	public UserDetails getUser(String no);
	public String addUser(SignInVO user);
	public String deleteUser(String emailId);
	public String updateUser(UserDetails user);
	public boolean signInUser(String userId, String password);
}
