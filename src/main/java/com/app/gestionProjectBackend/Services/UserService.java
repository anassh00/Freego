package com.app.gestionProjectBackend.Services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.gestionProjectBackend.Repository.UserRepository;
import com.app.gestionProjectBackend.models.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User update(Long id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}
	
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
	
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
	
	public Optional<List<User>> findByRole(Long id) {
		return userRepository.findByRoles_Id(id);
	}

}
