package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="User")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
	private Long id;
	
	private String name;
	
	private String role;
	
	private String type;
	
	public User() {
		
	}
	
	public User(String name, String role, String type) {
		super();
		this.name = name;
		this.role = role;
		this.type = type;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [name=");
		builder.append(name);
		builder.append(", role=");
		builder.append(role);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
