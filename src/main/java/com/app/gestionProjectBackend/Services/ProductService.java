package com.app.gestionProjectBackend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.gestionProjectBackend.Repository.ProductRepository;
import com.app.gestionProjectBackend.Security.Services.UserDetailsImpl;
import com.app.gestionProjectBackend.models.EProductStatus;
import com.app.gestionProjectBackend.models.Product;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	@Transactional
	public Product add(Product product) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();	
		product.setUser(userService.findById(userDetails.getId()).get());
		Product newProduct = productRepository.save(product);
		return newProduct;
	}
	
	@Transactional
	public Product update(Long id, Product product) {
		return update(id, product, 0L);
	}
	
	@Transactional
	public Product update(Long id, Product product, Long categoryId) {
		Product productOld = findById(id).get();
		if(product.getDescription() != null) {
			productOld.setDescription(product.getDescription());
		}
		if(product.getName() != null) {
			productOld.setName(product.getName());
		}
		if(product.getQuantity_stock() == 0) {
			productOld.setQuantity_stock(product.getQuantity_stock());
		}
		if(product.getStatus() != null) {
			productOld.setStatus(product.getStatus());
		}
		if(product.getUser() != null) {
			productOld.setUser(product.getUser());
		}
		if(categoryId != 0) {
			productOld.setCategory(categoryService.findById(categoryId).get());
		}
		Product productToUpdate = productRepository.save(productOld);
		return productToUpdate;
	}
	
	@Transactional
	public Product delete(Long id) {
		Product productOld = findById(id).get();
		productOld.setStatus(EProductStatus.DELETED);
		Product productToUpdate = productRepository.save(productOld);
		return productToUpdate;
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
