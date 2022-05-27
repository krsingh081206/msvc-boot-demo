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
public class DemoRunner implements CommandLineRunner{

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderItemRepository orderItemRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		// TODO Auto-generated method stub
		Order order = new Order();
		
		OrderItem item1 = new OrderItem();
		item1.setItemName("Pizza");
		item1.setItemPrice("Rs-250");
		
		OrderItem item2 = new OrderItem();
		item2.setItemName("Diet Coke");
		item2.setItemPrice("Rs-60");
		
		item1.setOrder(order);
		
		item2.setOrder(order);
		
		
		orderRepo.save(order);
		
		orderItemRepo.save(item1);
		
		orderItemRepo.save(item2);
		
		
	}
	
	

}
