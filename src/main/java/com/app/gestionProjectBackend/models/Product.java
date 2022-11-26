package com.app.gestionProjectBackend.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;


@Entity
@Table(name = "product")
public class Product implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_product ;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;
	
	private String name;
	private String description;
	private int quantity_stock;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20) 
	private EProductStatus status;
	private Long creation_date;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
    @OneToMany(mappedBy = "product")
    private Set<OrderProduct> order_product;
    
    @OneToMany(mappedBy = "product")
    private Set<CarteProduct> carte_product;
	
	// src img
//	private String img;
//	
//	public String getImg() {
//		return img;
//	}
//	public void setImg(String img) {
//		this.img = img;
//	}

	@PrePersist
	protected void onCreate() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		creation_date = timestamp.getTime();
	}

	@Override
	public String toString() {
		return "Product [id_product=" + id_product + ", name="
				+ name +  "]";
	}
	
	public Long getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Long creation_date) {
		this.creation_date = creation_date;
	}

	public long getId_product() {
		return id_product;
	}


	public void setId_product(long id_product) {
		this.id_product = id_product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity_stock() {
		return quantity_stock;
	}

	public void setQuantity_stock(int quantity_stock) {
		this.quantity_stock = quantity_stock;
	}

	public EProductStatus getStatus() {
		return status;
	}

	public void setStatus(EProductStatus status) {
		this.status = status;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderProduct> getOrder_product() {
		return order_product;
	}

	public void setOrder_product(Set<OrderProduct> order_product) {
		this.order_product = order_product;
	}

	public Set<CarteProduct> getCarte_product() {
		return carte_product;
	}

	public void setCarte_product(Set<CarteProduct> carte_product) {
		this.carte_product = carte_product;
	}

}
