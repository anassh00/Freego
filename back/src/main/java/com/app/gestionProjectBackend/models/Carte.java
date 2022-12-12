package com.app.gestionProjectBackend.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_carte")
public class Carte {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	private Long creation_date;
	private String delivery_address;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
    @OneToMany(mappedBy = "carte")
    private Set<CarteProduct> carte_product;

	public Long getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Long creation_date) {
		this.creation_date = creation_date;
	}

	public String getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
