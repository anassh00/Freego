package com.app.gestionProjectBackend.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shoppingcarte_product")
public class CarteProduct {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	private int quantity;
	
    @ManyToOne
    @JoinColumn(name = "carteId")
    private Carte carte;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
