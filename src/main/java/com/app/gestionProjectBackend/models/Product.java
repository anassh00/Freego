package com.app.gestionProjectBackend.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;


@Entity
public class Product implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_product ;
	
//	@ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL})
//	@JoinColumn(name="category_id")
//	private SousCategory category ;
	
//	@OneToOne(cascade = {CascadeType.ALL})
//	@JoinColumn(name="supplier_id")
//	private Supplier supplier;
	
	private String name;
	private String description;
	private int quantity_stock;
	private int status;
	private Long creation_date;
	// src img
	private String img;
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
