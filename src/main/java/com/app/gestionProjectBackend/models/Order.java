package com.app.gestionProjectBackend.models;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


@Entity
@Table(name="commande") 
public class Order {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id_order;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	private int status;
	private String addresse;
	
	private Long creation_date_timestamp;
	private Long update_date_timestamp;
	
    @OneToMany(mappedBy = "order")
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
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
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
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public Set<OrderProduct> getOrder_product() {
		return order_product;
	}
	public void setOrder_product(Set<OrderProduct> order_product) {
		this.order_product = order_product;
	}	
	
}
