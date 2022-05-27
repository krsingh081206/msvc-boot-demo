package com.example.mongo.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.order.demo.order.Order;
import com.example.mongo.order.demo.order.OrderRepository;

@RestController
@RequestMapping("/api")
public class OrderDemoController {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@GetMapping("/orders/id/{orderId}")
	public Order fetchOrder(@PathVariable("orderId") String orderId) {
		
		return orderRepo.findByOrderId(orderId);
		
	}

	@GetMapping("/orders/account/{accountId}")
	public List<Order> fetchOrderByAccount(@PathVariable("accountId") String accountId) {
		
		return orderRepo.findByAccountNumber(accountId);
		
	}
}
