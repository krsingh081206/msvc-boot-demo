package com.msvc.boot.msauthsvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msvc.boot.msauthsvc.entity.AuthUser;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser,Long>{

}
