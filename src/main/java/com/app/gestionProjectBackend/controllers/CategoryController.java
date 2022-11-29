package com.app.gestionProjectBackend.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.gestionProjectBackend.Security.Payload.Response.MessageResponse;
import com.app.gestionProjectBackend.Services.CategoryService;
import com.app.gestionProjectBackend.models.Category;
import com.app.gestionProjectBackend.models.Product;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveCategory(@RequestBody Category category) {
		try {
			categoryService.add(category);
			return ResponseEntity.ok(new MessageResponse("Category registered successfully!"));
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}
	
	@RequestMapping(value = "/getCategory", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getCategory(@RequestParam Long id) {
		try {
			Category category = categoryService.findById(id).get();
			return new ResponseEntity<Category>(category, HttpStatus.OK);
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}

	@GetMapping("/listCategory")
	public ResponseEntity<?> allCategory() {
		try {
			ArrayList<Category> result = new ArrayList<>();
			Iterable<Category> list = categoryService.findAll();
			if(list != null) {
				list.forEach(category -> {
					result.add(category);
				});
			}
			return new ResponseEntity<ArrayList<Category>>(result, HttpStatus.OK);
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}
}
