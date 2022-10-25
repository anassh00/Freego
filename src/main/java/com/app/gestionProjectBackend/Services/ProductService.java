package com.app.gestionProjectBackend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.gestionProjectBackend.Repository.ProductRepository;
import com.app.gestionProjectBackend.models.Product;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Transactional
	public Product add(Product product) {
		Product newProduct = productRepository.save(product);
		return newProduct;
	}
}
