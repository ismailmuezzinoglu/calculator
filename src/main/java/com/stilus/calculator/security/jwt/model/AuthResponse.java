package com.stilus.calculator.security.jwt.model;

public class AuthResponse {

	private final String jwt;

	public AuthResponse(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

}
