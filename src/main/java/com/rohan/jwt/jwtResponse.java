package com.rohan.jwt;

public class jwtResponse {
	
	private String token;
	
	public jwtResponse() {
		super();
	}

	public jwtResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

}
