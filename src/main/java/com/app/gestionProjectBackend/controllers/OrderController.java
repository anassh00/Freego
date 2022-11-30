package com.app.gestionProjectBackend.controllers;

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

import com.app.gestionProjectBackend.Dto.Request.OrderRequestDto;
import com.app.gestionProjectBackend.Services.OrderService;
import com.app.gestionProjectBackend.models.Order;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveOrder(@RequestBody OrderRequestDto order) {
		try {
			Order orderRes = orderService.addOrder(order);
			return new ResponseEntity<Order>(orderRes, HttpStatus.OK);
		}catch(Exception e){
	        e.printStackTrace(); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An internal error has occurred");
		}
	}
}
