package com.app.gestionProjectBackend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.gestionProjectBackend.Repository.UserRepository;
import com.app.gestionProjectBackend.models.EAccountStatus;
import com.app.gestionProjectBackend.models.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User update(Long id, User user) {
		User userOld = findById(id).get();
//		if(user.getEmail() != null) {
//			user.setEmail(user.getEmail());
//		}
		if(user.getAddress() != null) {
			userOld.setAddress(user.getAddress());
		}
		if(user.getFirst_name() != null){
			userOld.setFirst_name(user.getFirst_name());
		}
		if(user.getLast_name() != null){
			userOld.setLast_name(user.getLast_name());
		}
		if(user.getPhone() != null){
			userOld.setPhone(user.getPhone());
		}
		if(user.getBiographie() != null) {
			userOld.setBiographie(user.getBiographie());
		}
//		if(user.getUsername() != null) {
//			userOld.setUsername(user.getUsername());
//		}
		if(user.getEntity_name() != null) {
			userOld.setEntity_name(user.getEntity_name());
		}
		return userRepository.save(userOld);
	}
	
	@Transactional
	public User delete(Long id) {
		User userOld = findById(id).get();
		userOld.setStatus(EAccountStatus.DELETED);
		User userToUpdate = userRepository.save(userOld);
		return userToUpdate;
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
