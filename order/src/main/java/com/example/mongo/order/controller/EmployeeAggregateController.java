package com.example.mongo.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.order.demo.employee.AgeCount;


import java.util.List;

@RestController
@RequestMapping("/aggregation")

public class EmployeeAggregateController {
	
	 @Autowired
	    private MongoTemplate mongoTemplate;


	    @GetMapping("/group")
	    public List<AgeCount> groupByAge() {

	        // grouping by age.
	        GroupOperation groupOperation = Aggregation.group("age").count().as("count");

	        // filtering same age count > 1

	        MatchOperation matchOperation = Aggregation.match(new Criteria("count").gt(0));


	        SortOperation sortOperation = Aggregation.sort(Sort.by(Sort.Direction.ASC, "count"));

	        Aggregation aggregation = Aggregation.newAggregation(groupOperation, matchOperation, sortOperation);

	        AggregationResults<AgeCount> result = mongoTemplate.aggregate(aggregation, "Employee", AgeCount.class);


	        return result.getMappedResults();
	    }

}
