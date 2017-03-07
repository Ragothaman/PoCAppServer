package com.shop.server.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.shop.server.config.HibernateConfiguration;
import com.shop.server.config.ShopServerConfiguration;
import com.shop.server.model.UserDetails;
import com.shop.server.persistence.UserDetailsDao;
import com.shop.server.service.UserDetailsService;

public class Client {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfiguration.class, ShopServerConfiguration.class);
		UserDetailsDao ud = (UserDetailsDao) context.getBean("userDetailsDao");
		UserDetailsService us = (UserDetailsService) context.getBean("userDetailsService");
		UserDetails details = new UserDetails();
		details.setEmailId("abc@gmail.com");
		//details.setAuthCode("bcadb445-cf28-4bbd-8747-0c21a44473f8");
		details.setPassword("");
		try {
			ud.addUser(details);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*System.out.println(ud.getAllUsers());
		System.out.println(ud.getUserWithMobile("12345").getEmailId());
		System.out.println(us.getAllUsers());
		System.out.println(us.getUser("12345").getMobileNumber());*/
		System.out.println(us.signInUser("abc@gmail.com", ""));
		
	}

}
