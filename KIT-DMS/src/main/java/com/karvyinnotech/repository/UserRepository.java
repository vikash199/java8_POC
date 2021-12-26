package com.karvyinnotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karvyinnotech.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	

	User findByEmilId(String email);
}
