package com.shop.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.server.service.UserDetailsService;
import com.shop.server.vo.SignInVO;

@RestController
public class SignInController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping(value = "/signin/user", method = RequestMethod.POST)
	public ResponseEntity<Boolean> signInUser(@RequestBody SignInVO signInVO) {
		String userId = signInVO.getUserId();
		String password = signInVO.getPassword();
		System.out.println("Logging In User " + userId);
		boolean response = userDetailsService.signInUser(userId, password);
		return new ResponseEntity<Boolean>(response, HttpStatus.OK);
	}
}
