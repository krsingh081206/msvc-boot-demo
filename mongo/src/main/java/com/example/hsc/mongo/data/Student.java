package com.example.hsc.mongo.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Student")
public class Student {
	
	@Id
	private String id;
	
	private String firstName;
	
	private String city;
	
	public Student() {
		
	}
	
	public Student(String firstName,String city) {
		
		this.firstName = firstName;
		this.city = city;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [firstName=");
		builder.append(firstName);
		builder.append(", city=");
		builder.append(city);
		builder.append("]");
		return builder.toString();
	}

	public String getId() {
		return id;
	}

}
