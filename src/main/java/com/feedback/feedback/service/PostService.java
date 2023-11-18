package com.feedback.feedback.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.feedback.feedback.dto.PostReponse;
import com.feedback.feedback.dto.UsersReponse;

@Service
public class PostService {
	
	public static String postUrl= "https://gorest.co.in/public/v2/users";

	public List<PostReponse> getAllPosts() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ArrayList> response
		  = restTemplate.getForEntity(postUrl,ArrayList.class);
		List<PostReponse> list=response.getBody();
		return list;	
	}
	
	public List<PostReponse> getAllPostsByUser(String name) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ArrayList> response
		  = restTemplate.getForEntity(postUrl,ArrayList.class);
		List<PostReponse> list=response.getBody();
		list=list.stream().filter(a-> a.name.equals(name)).collect(Collectors.toList());
		return list;
	}
	
	
}
