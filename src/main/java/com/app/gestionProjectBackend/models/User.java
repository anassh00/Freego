package com.app.gestionProjectBackend.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(	name = "utilisateur", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String email;
	@JsonIgnore
	private String password;
	
	private String phone;
	private String first_name;
	private String last_name;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20) 
	private EAccountStatus status;
	
	private Long creation_date_timestamp;
	private Long update_date_timestamp;

	private String address;
	  
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)

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

	public EAccountStatus getStatus() {
		return status;
	}
	public void setStatus(EAccountStatus status) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public User() {
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
