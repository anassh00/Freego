package com.app.gestionProjectBackend.Dto.Response;

import com.app.gestionProjectBackend.models.Product;

public class OrderProductResponseDto {
	
	private long id ;
	private Product product;
	private int quantity;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
