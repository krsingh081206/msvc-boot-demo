package com.example.mongo.order.demo.order;

import com.example.mongo.order.demo.address.Address;
import com.example.mongo.order.demo.address.AddressType;
import com.example.mongo.order.demo.data.BaseEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document
public class Order extends BaseEntity {

 @Id
 private String orderId;

 private String accountNumber;

 private OrderStatus orderStatus;

 private List<LineItem> lineItems = new ArrayList<>();

 private Address shippingAddress;
 
 public Order() {
	 
 }

 public Order(String accountNumber, Address shippingAddress) {
  this.accountNumber = accountNumber;
  this.shippingAddress = shippingAddress;
  this.shippingAddress.setAddressType(AddressType.SHIPPING);
  this.orderStatus = OrderStatus.PENDING;
 }

 public void addLineItem(LineItem lineItem) {
  this.lineItems.add(lineItem);
 }

public String getOrderId() {
	return orderId;
}

public void setOrderId(String orderId) {
	this.orderId = orderId;
}

public String getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}

public OrderStatus getOrderStatus() {
	return orderStatus;
}

public void setOrderStatus(OrderStatus orderStatus) {
	this.orderStatus = orderStatus;
}

public List<LineItem> getLineItems() {
	return lineItems;
}

public void setLineItems(List<LineItem> lineItems) {
	this.lineItems = lineItems;
}

public Address getShippingAddress() {
	return shippingAddress;
}

public void setShippingAddress(Address shippingAddress) {
	this.shippingAddress = shippingAddress;
}
}
