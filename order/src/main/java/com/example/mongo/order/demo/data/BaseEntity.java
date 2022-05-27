package com.example.mongo.order.demo.data;


import org.joda.time.DateTime;


public class BaseEntity {

 private DateTime lastModified, createdAt;

public DateTime getLastModified() {
	return lastModified;
}

public void setLastModified(DateTime lastModified) {
	this.lastModified = lastModified;
}

public DateTime getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(DateTime createdAt) {
	this.createdAt = createdAt;
}
}
