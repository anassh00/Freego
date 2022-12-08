package com.app.gestionProjectBackend.controllers;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.gestionProjectBackend.Dto.Request.UserRequestDto;
import com.app.gestionProjectBackend.Repository.RoleRepository;
import com.app.gestionProjectBackend.Repository.UserRepository;
import com.app.gestionProjectBackend.Security.Jwt.JwtUtils;
import com.app.gestionProjectBackend.Security.Payload.Request.LoginRequest;
import com.app.gestionProjectBackend.Security.Payload.Response.JwtResponse;
import com.app.gestionProjectBackend.Security.Payload.Response.JwtResponseDto;
import com.app.gestionProjectBackend.Security.Payload.Response.MessageResponse;
import com.app.gestionProjectBackend.Security.Services.UserDetailsImpl;
import com.app.gestionProjectBackend.models.EAccountStatus;
import com.app.gestionProjectBackend.models.ERole;
import com.app.gestionProjectBackend.models.Role;
import com.app.gestionProjectBackend.models.User;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	private static String jwtSecret = "testts";

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws UnsupportedEncodingException {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
	
	
			
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
			List<String> roles = userDetails.getAuthorities().stream()
					.map(item -> item.getAuthority())
					.collect(Collectors.toList());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtTokenBis(authentication, userDetails, roles);
			JwtResponseDto resp = new JwtResponseDto();
			resp.setStatus(true);
			resp.setToken(jwt);
			resp.setEmail(userDetails.getEmail());
			resp.setId(userDetails.getId());
			resp.setUsername(userDetails.getUsername());
			//resp.setToken(decodeJWT(jwt));
			return ResponseEntity.ok(resp);
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) throws UnsupportedEncodingException {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
	
	
			
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
			List<String> roles = userDetails.getAuthorities().stream()
					.map(item -> item.getAuthority())
					.collect(Collectors.toList());
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication) ;
			return ResponseEntity.ok(new JwtResponse(jwt, 
													 userDetails.getId(), 
													 userDetails.getUsername(), 
													 userDetails.getEmail(), 
													 roles));
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody UserRequestDto userDto) {
		try {
			if (userRepository.existsByUsername(userDto.getUsername())) {
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse("Error: Username is already taken!"));
			}
	
//			if (userRepository.existsByEmail(userDto.getEmail())) {
//				return ResponseEntity
//						.badRequest()
//						.body(new MessageResponse("Error: Email is already in use!"));
//			}
			User user = new User();
			user.setUsername(userDto.getUsername());
			user.setEmail(userDto.getUsername());
			user.setAddress(userDto.getAddress());
			user.setFirst_name(userDto.getFirst_name());
			user.setLast_name(userDto.getLast_name());
			user.setPhone(userDto.getPhone());
			user.setLatitude(userDto.getLatitude());
			user.setLongitude(userDto.getLongitude());
			user.setBiographie(userDto.getBiographie());
			user.setEntity_name(userDto.getEntity_name());
			if(!userDto.getRoles().isEmpty()) {
				Set<Role> roles =  new HashSet<>();
				roles.add(roleRepository.findByName(ERole.ROLE_USER).get());
				for(String role : userDto.getRoles()) {
					if(role.equals("admin")) {
						roles.add(roleRepository.findByName(ERole.ROLE_ADMIN).get());
					}else if (role.equals("moderateur")) {
						roles.add(roleRepository.findByName(ERole.ROLE_MODERATOR).get());
					}
				}
				user.setRoles(roles);
			}else {
				Set<Role> roles =  new HashSet<>();
				roles.add(roleRepository.findByName(ERole.ROLE_USER).get());
				user.setRoles(roles);
			}
			user.setPassword(encoder.encode(userDto.getPassword()));
			user.setStatus(EAccountStatus.ACTIVE);
			
			User u = userRepository.saveAndFlush(user);		
			return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}

}
