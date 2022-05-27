package com.example.hsc.mongo.data;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface StudentRepository extends PagingAndSortingRepository<Student,String>{
	
	
	List<Student> findByCity(String city);

}
