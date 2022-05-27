package com.example.mongo.order.runner;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.mongo.order.demo.employee.Employee;
import com.example.mongo.order.demo.employee.EmployeeRepository;

@Component
public class EmployeeDemoRunner implements CommandLineRunner{
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeDemoRunner.class);

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Employee emp = new Employee("Ritesh",38,12345l,DateTime.now());
		emp = employeeRepo.save(emp);
		logger.info("Saved Employee : {} ",emp);
		
	}

}
