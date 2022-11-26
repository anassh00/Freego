package com.app.gestionProjectBackend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.gestionProjectBackend.Repository.ProductRepository;
import com.app.gestionProjectBackend.models.EProductStatus;
import com.app.gestionProjectBackend.models.Product;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Transactional
	public Product add(Product product) {
		Product newProduct = productRepository.save(product);
		return newProduct;
	}
	
	@Transactional
	public Product update(Long id, Product product, Long categoryId) {
		product.setId_product(id);
		if(categoryId != null) {
			product.setCategory(categoryService.findById(categoryId).get());
		}
		Product productToUpdate = productRepository.save(product);
		return productToUpdate;
	}
	
	@Transactional
	public Product delete(Long id, Product product) {
		product.setId_product(id);
		product.setStatus(EProductStatus.DELETED);
		return null;
	}
	
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}
	
	public Optional<List<Product>> findByCategory(Long id) {
		return productRepository.findByCategory_Id(id);
	}
}
