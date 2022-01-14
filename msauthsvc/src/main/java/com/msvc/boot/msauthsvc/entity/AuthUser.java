package com.msvc.boot.msauthsvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "AUTH_USER")
@Table(name = "AUTH_USER_T")
public class AuthUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "USER_ID",nullable = false)
	private String userId;
	
	@Column(name = "USER_PASSWD",nullable = false)
	private String password;
	
	@Column(name = "USER_FNAME",nullable = false)
	private String firstName;
	
	@Column(name = "USER_LNAME",nullable = false)
	private String lastName;
	
	@Column(name = "USER_EMAIL",nullable = false)
	private String email;
	
	@Column(name = "USER_ROLE",nullable = false)
	private String role;
	
	@Column(name = "USER_REFRESH_TOKEN",nullable = false)
	private String refreshToken;

	public Long getId() {
		return id;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
		builder.append("AuthUser [id=");
		builder.append(id);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", password=");
		builder.append(password);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", role=");
		builder.append(role);
		builder.append(", refreshToken=");
		builder.append(refreshToken);
		builder.append("]");
		return builder.toString();
	}
	

}
