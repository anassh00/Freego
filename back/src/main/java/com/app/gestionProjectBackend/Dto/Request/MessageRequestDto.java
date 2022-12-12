package com.app.gestionProjectBackend.Dto.Request;

public class MessageRequestDto {

	private Long id;
	private Long userSenderId;
	private Long userReceiverId;
	private String text;
	private boolean read;
	private Long creation_date_timestamp;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getUserReceiverId() {
		return userReceiverId;
	}
	public void setUserReceiverId(Long userReceiverId) {
		this.userReceiverId = userReceiverId;
	}
	public Long getUserSenderId() {
		return userSenderId;
	}
	public void setUserSenderId(Long userSenderId) {
		this.userSenderId = userSenderId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public Long getCreation_date_timestamp() {
		return creation_date_timestamp;
	}
	public void setCreation_date_timestamp(Long creation_date_timestamp) {
		this.creation_date_timestamp = creation_date_timestamp;
	}
	
}
