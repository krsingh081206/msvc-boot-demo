package com.example.demo.runner;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.repo.OrderItemRepository;
import com.example.demo.repo.OrderRepository;



@Component
@Transactional
public class OrderRunner implements CommandLineRunner{

	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	OrderItemRepository orderItemRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Order order1 = new Order() ;
		order1.setOrderType("PrePaid");
		
	
		
		
		OrderItem orderItem1 = new OrderItem();
		orderItem1.setItemName("Perfume");
		orderItem1.setItemPrice("25");
		
		OrderItem orderItem2 = new OrderItem();
		orderItem2.setItemName("Shirt");
		orderItem2.setItemPrice("205");
		
		orderItem1.setOrder(order1);
		
		orderItem2.setOrder(order1);
		
		orderRepo.save(order1);
		
		orderItemRepo.save(orderItem1);
		orderItemRepo.save(orderItem2);
		
		// TODO Auto-generated method stub
		
	}

}
