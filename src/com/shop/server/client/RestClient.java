package com.shop.server.client;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.server.model.UserDetails;

public class RestClient {

	public static final String REST_SERVICE_URI = "http://localhost:8080/SelfieShoppeServer";
	
	public static void main(String[] args) {
		listAllUsers();
		getUser("abc@gmail.com");
	}

	private static void getUser(String emailId) {
		System.out.println("List User method starts");
		RestTemplate rt = new RestTemplate();
		UserDetails user = rt.getForObject(REST_SERVICE_URI+"/user/", UserDetails.class, emailId);
		System.out.println("User name is " + user.getEmailId());
		System.out.println("List User method ends");
	}
	
	private static void listAllUsers() {
		System.out.println("List All Users method starts");
		RestTemplate rt = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		
		List<UserDetails> users = mapper.convertValue(rt.getForObject(REST_SERVICE_URI+"/users", List.class), new TypeReference<List<UserDetails>>() {} );
		if(users != null) {
			for(UserDetails u : users){
				System.out.println(u.getEmailId());
			}
		} else {
			System.out.println("No Users exists");
		}
		System.out.println("List All Users method ends");
	}
}
