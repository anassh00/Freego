package com.app.gestionProjectBackend.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.gestionProjectBackend.Repository.CategoryRepository;
import com.app.gestionProjectBackend.models.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}
	
	@Transactional
	public Category add(Category category) {
		Category newCategory = categoryRepository.save(category);
		return newCategory;
	}
	
	@Transactional
	public Category update(Long id, Category category) {
		category.setId(id);
		return categoryRepository.save(category);
	}
	
	public Iterable<Category> findAll() {
		return categoryRepository.findAll();
	}
}
