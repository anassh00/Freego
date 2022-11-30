package com.app.gestionProjectBackend.models;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="commande") 
public class Order {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id_order;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20) 
	private EOrderStatus status;
	private String address;
	
	private Long creation_date_timestamp;
	private Long update_date_timestamp;
	
    @OneToMany(cascade = {CascadeType.ALL} , orphanRemoval = true, mappedBy = "order")
    @JsonIgnore
    private Set<OrderProduct> order_product;
	
	@PrePersist
	protected void onCreate() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		creation_date_timestamp = timestamp.getTime();
	}
	@PreUpdate
	protected void onUpdate() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		update_date_timestamp = timestamp.getTime();
	}
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<OrderProduct> getOrder_product() {
		return order_product;
	}
	public void setOrder_product(Set<OrderProduct> order_product) {
		this.order_product = order_product;
	}	
	
}
