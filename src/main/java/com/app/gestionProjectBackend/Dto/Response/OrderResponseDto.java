package com.app.gestionProjectBackend.Dto.Response;

import java.util.Set;

import com.app.gestionProjectBackend.models.EOrderStatus;
import com.app.gestionProjectBackend.models.OrderProduct;
import com.app.gestionProjectBackend.models.User;

public class OrderResponseDto {

	private long id_order;
	private User user;
	private EOrderStatus status;
	private String address;
	
	private Long creation_date_timestamp;
	private Long update_date_timestamp;
	
	private Set<OrderProductResponseDto> order_product;

	public long getId_order() {
		return id_order;
	}

	public void setId_order(long id_order) {
		this.id_order = id_order;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EOrderStatus getStatus() {
		return status;
	}

	public void setStatus(EOrderStatus status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getCreation_date_timestamp() {
		return creation_date_timestamp;
	}

	public void setCreation_date_timestamp(Long creation_date_timestamp) {
		this.creation_date_timestamp = creation_date_timestamp;
	}

	public Long getUpdate_date_timestamp() {
		return update_date_timestamp;
	}

	public void setUpdate_date_timestamp(Long update_date_timestamp) {
		this.update_date_timestamp = update_date_timestamp;
	}

	public Set<OrderProductResponseDto> getOrder_product() {
		return order_product;
	}

	public void setOrder_product(Set<OrderProductResponseDto> order_product) {
		this.order_product = order_product;
	}
	
}
