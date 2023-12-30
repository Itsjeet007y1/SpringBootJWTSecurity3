package com.example.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security.model.AuthenticationRequest;
import com.example.security.model.AuthenticationResponse;
import com.example.security.model.RegisterRequest;
import com.example.security.repository.UserRepository;
import com.example.security.user.Role;
import com.example.security.user.User;
import com.example.security.util.JwtUtil;

@Service
public class AuthenticationService {

	@Autowired
	public final UserRepository userRepository;
	
	@Autowired
	public final PasswordEncoder passwordEncoder;
	
	@Autowired
	public final JwtUtil jwtUtil;
	
	@Autowired
	public final AuthenticationManager authenticationManager;
	
	
	public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil,
			AuthenticationManager authenticationManager) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
		this.authenticationManager = authenticationManager;
	}


	public AuthenticationResponse register(RegisterRequest request) {
		var user = new User();
		user.setFirstname(request.getFirstname());
		user.setLastname(request.getLastname());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(Role.USER);
		
		userRepository.save(user);
		
		var jwtToken = jwtUtil.generateToken(user);
		
		AuthenticationResponse authenticationResponse = new AuthenticationResponse();
		authenticationResponse.setToken(jwtToken);
		return authenticationResponse;
	}
	
	
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(),
						request.getPassword()));
		var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
		var jwtToken = jwtUtil.generateToken(user);
		AuthenticationResponse response = new AuthenticationResponse();
		response.setToken(jwtToken);
		return response;
	}
	
	
}
