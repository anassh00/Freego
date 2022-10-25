package com.app.gestionProjectBackend.Security.Payload.Response;

public class JwtResponseDto {

	private Boolean status;
	private String token;
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}