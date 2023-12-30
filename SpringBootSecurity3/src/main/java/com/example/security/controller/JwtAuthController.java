package com.example.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.model.AuthenticationRequest;
import com.example.security.model.AuthenticationResponse;
import com.example.security.model.RegisterRequest;
import com.example.security.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
public class JwtAuthController {

	@Autowired
	private final AuthenticationService authenticationService;
	
	public JwtAuthController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(authenticationService.register(request));
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(authenticationService.authenticate(request));
	}
}
