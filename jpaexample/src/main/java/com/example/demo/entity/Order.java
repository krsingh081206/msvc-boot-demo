package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;
import com.example.demo.entity.OrderItem;

@Entity
@Table(name = "ORDERS_T")
public class Order extends AbstractEntity {

	
	private static final long serialVersionUID = 1L;
	
	private String orderType;
	
	//private Set<OrderItem> items = new HashSet();

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

//	public Set<OrderItem> getItems() {
//		return items;
//	}
//
//	public void setItems(Set<OrderItem> items) {
//		this.items = items;
//	}

}
