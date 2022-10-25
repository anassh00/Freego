package com.app.gestionProjectBackend.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.gestionProjectBackend.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	
	public Page<Product> findByNameContains(String mc, Pageable pageable);

}
