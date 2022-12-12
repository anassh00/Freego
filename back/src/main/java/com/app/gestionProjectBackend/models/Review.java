package com.app.gestionProjectBackend.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;

	@ManyToOne
	@JoinColumn(name="userSenderId")
	private User userSender;
	
	@ManyToOne
	@JoinColumn(name="userReceiverId")
	private User userReceiver;
	
	private int rating;
	private String comment;
	private Long creation_date;
	
	@PrePersist
	protected void onCreate() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		creation_date = timestamp.getTime();
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Long creation_date) {
		this.creation_date = creation_date;
	}

	public User getUserSender() {
		return userSender;
	}

	public void setUserSender(User userSender) {
		this.userSender = userSender;
	}

	public User getUserReceiver() {
		return userReceiver;
	}

	public void setUserReceiver(User userReceiver) {
		this.userReceiver = userReceiver;
	}
	
}
