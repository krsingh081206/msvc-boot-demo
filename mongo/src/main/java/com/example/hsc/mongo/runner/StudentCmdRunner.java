package com.example.hsc.mongo.runner;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.hsc.mongo.data.Student;
import com.example.hsc.mongo.data.StudentRepository;

@Component
@Transactional
public class StudentCmdRunner implements CommandLineRunner{
	
	@Autowired
	private StudentRepository studentRepo;
	
	private static Logger logger = LoggerFactory.getLogger(StudentCmdRunner.class);

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Student student1 = new Student("Ritesh","Gurgaon");
		
		student1 = studentRepo.save(student1);
		
		logger.info("Student 1 id ###### {} and details {} ",student1.getId(), student1 );
		
		Student student2 = new Student("Aseem","Mumbai");
		
		student2 = studentRepo.save(student2);
		
		logger.info("Student 2 id ###### {} and details {} ",student2.getId(), student2 );
		
		List<Student> studentList = studentRepo.findByCity("Mumbai");
		for(Student student : studentList) {
			
			logger.info("Student  {} ", student);
			
		}
		
		
	}

}
