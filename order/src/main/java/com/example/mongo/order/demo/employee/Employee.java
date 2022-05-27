package com.example.mongo.order.demo.employee;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employee")

public class Employee {
	
	public Employee() {
		
	}

	public Employee(String name, int age, Long phoneNumber, DateTime dateOfJoin) {
		super();
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.dateOfJoin = dateOfJoin;
	}

	@Id
	private String id;
	private String name;
	private int age;
	private Long phoneNumber;
	private DateTime dateOfJoin;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public DateTime getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(DateTime dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", dateOfJoin=");
		builder.append(dateOfJoin);
		builder.append("]");
		return builder.toString();
	}

}
