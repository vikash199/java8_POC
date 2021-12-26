package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.User;
import com.example.entities.UserRoleMapping;

public interface UserRoleRepository extends JpaRepository<UserRoleMapping, Integer>{
	
	UserRoleMapping findByUsers(User user);

}
