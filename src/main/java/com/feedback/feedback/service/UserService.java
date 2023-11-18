package com.feedback.feedback.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.feedback.feedback.dto.UsersReponse;

@Service
public class UserService {
	public List<UsersReponse> getAllUsers() {
		RestTemplate restTemplate = new RestTemplate();
		String userUrl
		  = "https://gorest.co.in/public/v2/users";
		ResponseEntity<ArrayList> response
		  = restTemplate.getForEntity(userUrl,ArrayList.class);
		List<UsersReponse> list=response.getBody();
		return list;	
	}

}
