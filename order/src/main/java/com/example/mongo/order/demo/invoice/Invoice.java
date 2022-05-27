package com.example.mongo.order.demo.invoice;

import com.example.mongo.order.demo.address.Address;
import com.example.mongo.order.demo.address.AddressType;
import com.example.mongo.order.demo.data.BaseEntity;
import com.example.mongo.order.demo.order.Order;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document
public class Invoice extends BaseEntity {

 @Id
 private String invoiceId;

 private String customerId;

 private List<Order> orders = new ArrayList<Order>();

 private Address billingAddress;

 private InvoiceStatus invoiceStatus;
 
 public Invoice() {
	 
 }

 public Invoice(String customerId, Address billingAddress) {
  this.customerId = customerId;
  this.billingAddress = billingAddress;
  this.billingAddress.setAddressType(AddressType.BILLING);
  this.invoiceStatus = InvoiceStatus.CREATED;
 }

 public void addOrder(Order order) {
  order.setAccountNumber(this.customerId);
  orders.add(order);
 }

public String getInvoiceId() {
	return invoiceId;
}

public void setInvoiceId(String invoiceId) {
	this.invoiceId = invoiceId;
}

public String getCustomerId() {
	return customerId;
}

public void setCustomerId(String customerId) {
	this.customerId = customerId;
}

public List<Order> getOrders() {
	return orders;
}

public void setOrders(List<Order> orders) {
	this.orders = orders;
}

public Address getBillingAddress() {
	return billingAddress;
}

public void setBillingAddress(Address billingAddress) {
	this.billingAddress = billingAddress;
}

public InvoiceStatus getInvoiceStatus() {
	return invoiceStatus;
}

public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
	this.invoiceStatus = invoiceStatus;
}
}