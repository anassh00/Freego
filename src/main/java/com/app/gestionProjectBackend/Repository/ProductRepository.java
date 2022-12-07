package com.app.gestionProjectBackend.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.gestionProjectBackend.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	
	public Page<Product> findByNameContains(String mc, Pageable pageable);

	public Optional<List<Product>> findByCategory_Id(Long id);
	
	@Query(value="SELECT * FROM product p where p.user_id = :userId", nativeQuery = true)
	public Optional<List<Product>> findByUserId(Long userId);
}
