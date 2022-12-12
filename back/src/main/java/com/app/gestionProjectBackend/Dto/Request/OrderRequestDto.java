package com.app.gestionProjectBackend.Dto.Request;

import java.util.Set;

public class OrderRequestDto {

	private long order_id;
	private long user_id;
	private String address;
	private Set<OrderProductRequestDto> productList;
	
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<OrderProductRequestDto> getProductList() {
		return productList;
	}
	public void setProductList(Set<OrderProductRequestDto> productList) {
		this.productList = productList;
	}
	
}
