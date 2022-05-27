package com.example.mongo.order.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.mongo.order.demo.address.Address;
import com.example.mongo.order.demo.invoice.Invoice;
import com.example.mongo.order.demo.invoice.InvoiceRepository;
import com.example.mongo.order.demo.order.LineItem;
import com.example.mongo.order.demo.order.Order;
import com.example.mongo.order.demo.order.OrderRepository;

@Component
public class MongoDemoRunner implements CommandLineRunner {
	

  
	 @Autowired
	 private OrderRepository orderRepository;

	 @Autowired
	 private InvoiceRepository invoiceRepository;
	 
	
	 
	 private static Logger logger = LoggerFactory.getLogger(MongoDemoRunner.class);
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// reset
		 orderRepository.deleteAll();
		  invoiceRepository.deleteAll();  		
		
		Address shippingAddress = new Address("1600 Pennsylvania Ave NW", null, "DC",
				   "Washington", "United States", 20500);
				  Order order = new Order("1001", shippingAddress);
				  order.addLineItem(new LineItem("Best. Cloud. Ever. (T-Shirt, Men's Large)",
				   "SKU-24642", 1, 21.99, .06));
				  order.addLineItem(new LineItem("Like a BOSH (T-Shirt, Women's Medium)",
				   "SKU-34563", 3, 14.99, .06));
				  order.addLineItem(new LineItem(
				   "We're gonna need a bigger VM (T-Shirt, Women's Small)", "SKU-12464", 4,
				   13.99, .06));
				  order.addLineItem(new LineItem("cf push awesome (Hoodie, Men's Medium)",
				   "SKU-64233", 2, 21.99, .06));
				  order = orderRepository.save(order);
				  
				  logger.info("Order Id : {} ",order.getOrderId());
				  
				  logger.info("Order Line Items size : {} ",order.getLineItems().size());
				  
								  // <2>
				  logger.info("Order Before save CreationTime  : {} and  LastModified {} ",order.getLastModified(), order.getCreatedAt());
				 
				  order = orderRepository.save(order);
				  logger.info("Order After save CreationTime  : {} and  LastModified {} ",order.getLastModified(), order.getCreatedAt());
				 

				  // <3>
				  Address billingAddress = new Address("875 Howard St", null, "CA",
				   "San Francisco", "United States", 94103);
				  String accountNumber = "1001";

				  Invoice invoice = new Invoice(accountNumber, billingAddress);
				  invoice.addOrder(order);
				  invoice = invoiceRepository.save(invoice);
				  
				  
				  logger.info("Invoice1 having {} Orders",invoice.getOrders().size());
				  
				  
				  Address shippingAddress1 = new Address("h.no. 433Sector 15", null, "HR",
						   "Gurgaon", "India", 122007);
						  Order order2 = new Order("1002", shippingAddress1);
						  order2.addLineItem(new LineItem("Aloo Burger",
						   "BURG-24642", 1, 1.99, .06));
						  order2.addLineItem(new LineItem("Cheese Pizza",
						   "PIZZ-34563", 3, 4.99, .06));
						  order2.addLineItem(new LineItem(
						   "200 ML Diet Coket", "COKE-12464", 2,
						   3.99, .06));
						  
						  order2 = orderRepository.save(order2);
						  
						  logger.info("Order2 Id : {} ",order2.getOrderId());
						  
						  logger.info("Order2 Line Items size : {} ",order2.getLineItems().size());
						  
						  Address billingAddress1 = new Address("Pizza Hut 01,SEC-14", null, "HR",
								   "GURGAON", "India", 122007);
								  String accountNumber1 = "1002";

								  Invoice invoice1 = new Invoice(accountNumber1, billingAddress1);
								  invoice1.addOrder(order2);
								  invoice1 = invoiceRepository.save(invoice1);
								  
								  logger.info("Invoice2 having {} Orders",invoice1.getOrders().size());		
								  
								  order2 = orderRepository.save(order2);
								  logger.info("Order After save CreationTime  : {} and  LastModified {} ",order2.getLastModified(), order2.getCreatedAt());

				 //
				 
		
	}

}
