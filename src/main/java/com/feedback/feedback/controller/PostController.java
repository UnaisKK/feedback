package com.feedback.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.feedback.dto.PostReponse;
import com.feedback.feedback.service.PostService;

import jakarta.websocket.server.PathParam;

@RestController
public class PostController {

	
	@Autowired
	PostService postService;
	
	@GetMapping("/post")
	List<PostReponse> getAllPosts() {
		return postService.getAllPosts();
	}
	
	@GetMapping("/post/{username}")
	List<PostReponse> getAllPosts(@PathParam(value = "username") String username) {
		return postService.getAllPostsByUser(username);
	}
	
}
