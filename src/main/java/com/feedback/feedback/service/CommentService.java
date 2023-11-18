package com.feedback.feedback.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.feedback.feedback.dto.CommentsResonse;
import com.feedback.feedback.dto.PostReponse;

@Service
public class CommentService {

	public static String commentsURL="https://gorest.co.in/public/v2/comments";
	public List<CommentsResonse> getAllComments() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ArrayList> response
		  = restTemplate.getForEntity(commentsURL,ArrayList.class);
		List<CommentsResonse> list=response.getBody();
		return list;	
	}

	public List<CommentsResonse> getAllCommentsFromPost(String post) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ArrayList> response
		  = restTemplate.getForEntity(commentsURL,ArrayList.class);
		List<CommentsResonse> list=response.getBody();
		return list.stream().filter(comments-> comments.post_id==post).collect(Collectors.toList());
	}
}
