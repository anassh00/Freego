package com.app.gestionProjectBackend.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="messaging") 
public class Message {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="userSenderId")
	private User userSender;
	
	@ManyToOne
	@JoinColumn(name="userReceiverId")
	private User userReceiver;
	
	private String messageText;
	private String messageRead;
	private Long creation_date_timestamp;
	
	@PrePersist
	protected void onCreate() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		creation_date_timestamp = timestamp.getTime();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getMessageRead() {
		return messageRead;
	}

	public void setMessageRead(String messageRead) {
		this.messageRead = messageRead;
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

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Long getCreation_date_timestamp() {
		return creation_date_timestamp;
	}

	public void setCreation_date_timestamp(Long creation_date_timestamp) {
		this.creation_date_timestamp = creation_date_timestamp;
	}
	
}
