package com.app.gestionProjectBackend.Dto.Request;

public class OrderProductRequestDto {
	
	private Long order_product_id;
	private Long orderId;
	private Long productId;
	private int quantity;
	private String productName;
	private String categoryName;
	
	public Long getOrder_product_id() {
		return order_product_id;
	}
	public void setOrder_product_id(Long order_product_id) {
		this.order_product_id = order_product_id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
