package com.feedback.feedback.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.feedback.dto.AuthRequest;
import com.feedback.feedback.dto.UsersReponse;
import com.feedback.feedback.service.JwtService;
import com.feedback.feedback.service.UserService;

@RestController
public class UsersController {

	@Autowired
	JwtService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserService userService;

	@GetMapping("/users")
	List<UsersReponse> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authRequest.username, authRequest.password));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.username);
		} else {
			throw new UsernameNotFoundException("invalid user request !");
		}

	}
}
