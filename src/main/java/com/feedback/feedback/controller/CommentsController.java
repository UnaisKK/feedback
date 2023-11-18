package com.feedback.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.feedback.dto.CommentsResonse;
import com.feedback.feedback.service.CommentService;

import jakarta.websocket.server.PathParam;

@RestController
public class CommentsController {

	@Autowired
	CommentService commentsService;
	
	@GetMapping("/comments")
	List<CommentsResonse> getAllUsers() {
		return commentsService.getAllComments();
	}
	
	@GetMapping("/commentsfrompost/{post}")
	List<CommentsResonse> getAllPosts(@PathParam(value = "post") String post) {
		return commentsService.getAllCommentsFromPost(post);
	}
}
