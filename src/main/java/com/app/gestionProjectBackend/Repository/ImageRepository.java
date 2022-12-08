package com.app.gestionProjectBackend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.gestionProjectBackend.models.Category;
import com.app.gestionProjectBackend.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
	Optional<Image> findByName(String name);
	
	@Query(value="SELECT * FROM images i where i.entity_name = :name", nativeQuery = true)
	Optional<Image> findByEntity_name(String name);
}