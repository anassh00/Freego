package com.app.gestionProjectBackend.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.gestionProjectBackend.Services.UserService;
import com.app.gestionProjectBackend.models.User;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> updateUser(@RequestParam Long id, @RequestBody User user) {
		try {
			User u = userService.update(id,user);
			return new ResponseEntity<>(u, HttpStatus.OK);
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> deleteUser(@RequestParam Long id) {
		try {
			User u = userService.delete(id);
			return new ResponseEntity<>(u, HttpStatus.OK);
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}
	
	@RequestMapping(value = "/listUser", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllUser() {
		try {
			ArrayList<User> result = new ArrayList<>();
			Iterable<User> list = userService.findAll();
			if(list != null) {
				list.forEach(user -> {
					result.add(user);
				});
			}
			return new ResponseEntity<ArrayList<User>>(result, HttpStatus.OK);
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> findProduct(@RequestParam Long id) {
		try {
			User user = userService.findById(id).get();
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}
	
}
