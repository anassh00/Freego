package com.app.gestionProjectBackend.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.gestionProjectBackend.Services.ProductService;
import com.app.gestionProjectBackend.models.Category;
import com.app.gestionProjectBackend.models.EProductStatus;
import com.app.gestionProjectBackend.models.Product;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveProduct(@RequestBody Product product, @RequestParam(required = false) Long category_id) {
		try {
			product.setStatus(EProductStatus.ACTIVE);
			Product p = productService.add(product,category_id);
			return new ResponseEntity<>(p, HttpStatus.OK);
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> updateProduct(@RequestParam Long id, @RequestParam(required = false) Long category_id, @RequestBody Product product) {
		try {
			Product p = productService.update(id,product,category_id);
			return new ResponseEntity<>(p, HttpStatus.OK);
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> deleteProduct(@RequestParam Long id) {
		try {
			Product p = productService.delete(id);
			return new ResponseEntity<>(p, HttpStatus.OK);
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}
	
	@RequestMapping(value = "/listProduct", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllProduct() {
		try {
			ArrayList<Product> result = new ArrayList<>();
			Iterable<Product> list = productService.findAll();
			if(list != null) {
				list.forEach(product -> {
					result.add(product);
				});
			}
			return new ResponseEntity<ArrayList<Product>>(result, HttpStatus.OK);
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}
	
	@RequestMapping(value = "/getProduct", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> findProduct(@RequestParam Long id) {
		try {
			Product product = productService.findById(id).get();
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}
	
	@RequestMapping(value = "/getProductsByCategory", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> findProductsByCategory(@RequestParam Long id) {
		try {
			List<Product> products = productService.findByCategory(id).get();
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}
	
	@RequestMapping(value = "/getProductsByUserId", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> findProductsByUser(@RequestParam Long id) {
		try {
			List<Product> products = productService.findByUser(id).get();
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}
}
