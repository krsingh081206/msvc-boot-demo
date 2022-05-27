package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser,Long>{
	
	AdminUser findByUserId(String userId);

}
