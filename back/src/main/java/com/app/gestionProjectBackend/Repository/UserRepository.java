package com.app.gestionProjectBackend.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.gestionProjectBackend.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Optional<List<User>> findByRoles_Id(Long id); 
	
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}