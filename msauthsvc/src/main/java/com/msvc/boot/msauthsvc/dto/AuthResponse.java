package com.msvc.boot.msauthsvc.dto;

public class AuthResponse {
	
	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthResponse(String authToken, String refreshToken) {
		super();
		this.authToken = authToken;
		this.refreshToken = refreshToken;
	}
	private String authToken;
	private String refreshToken;
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AuthResponse [authToken=");
		builder.append(authToken);
		builder.append(", refreshToken=");
		builder.append(refreshToken);
		builder.append("]");
		return builder.toString();
	}

}
